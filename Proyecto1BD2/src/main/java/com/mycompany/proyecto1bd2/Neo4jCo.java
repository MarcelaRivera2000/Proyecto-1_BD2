
package com.mycompany.proyecto1bd2;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import javax.swing.JOptionPane;
import org.neo4j.driver.Record;
import org.neo4j.driver.Session;
import org.neo4j.driver.Result;
import org.neo4j.driver.Transaction;
import static org.neo4j.driver.Values.parameters;
import org.neo4j.driver.TransactionWork;

public class Neo4jCo implements AutoCloseable{
    private final Driver driver;

    public Neo4jCo( String uri, String user, String password ){
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ));
    }

    public void close() throws Exception{
        driver.close();
    }
    
    /*CREAR ALUMNO*/
    public long addAlumno( final String name,final int id,final String user,final String pass ){
    try ( Session session = driver.session() ){
        session.writeTransaction( new TransactionWork<Void>(){
            @Override
            public Void execute( Transaction tx ){
                tx.run( "CREATE (a:Alumno{nombre:$nombre, id:$id, password:$pass, usuario:$usuario})", parameters("nombre", name, "id", id, "pass", pass, "usuario", user) );
                return null;
            }});
       
    }
        return 0;
    }
    
    /*CREAR CLASE*/
    public long addClase( final String name,final int id){
    try ( Session session = driver.session() ){
        session.writeTransaction( new TransactionWork<Void>(){
            @Override
            public Void execute( Transaction tx ){
                tx.run( "CREATE (c:Clase{nombre:$nombre, id:$id})", parameters("nombre", name, "id", id) );
                return null;
            }});
    }
    return 0;
    }
    
    /*CREAR PREGUNTAS*/
    public long addPregunta( final String titulo,final int id,final String descripcion,final int idClase ){
    try ( Session session = driver.session() ){
        session.writeTransaction( new TransactionWork<Void>(){
            @Override
            public Void execute( Transaction tx ){
                return createPregunta( tx, titulo,id,descripcion,idClase );
            }});
         session.writeTransaction( new TransactionWork<Void>(){
            @Override
            public Void execute( Transaction tx ){
                Result result = tx.run("MATCH (a:Pregunta),(b:Clase) WHERE a.id =$id AND b.id =$idClase CREATE (a)-[r:APLICADO_EN]->(b) RETURN r", parameters( "id", id, "idClase", idClase));
                return null;
                
            }});
    
    }
        return 0;
   
    }
    
    private static Void createPregunta( Transaction tx, String titulo, int id, String descripcion, int idClase )
    {
    tx.run( "CREATE (p:Pregunta{titulo:$titulo, id:$id, idClase:$idClase, descripcion:$descripcion})", parameters("titulo", titulo, "id", id, "idClase", idClase, "descripcion", descripcion) );
    return null;
    }
    
    /*CREAR EXAMENES*/
    public Boolean addExamen(final int id,final int nump,final int idClase ){
    try ( Session session = driver.session() ){
        session.writeTransaction( new TransactionWork<Void>(){
            @Override
            public Void execute( Transaction tx ){
                tx.run( "CREATE (p:Examen{id:$id, id:$id, idClase:$idClase, nump:$nump})", parameters("id", id,"nump",nump, "idClase", idClase) );
                return null;
            }}); 
            session.writeTransaction( new TransactionWork<Void>(){
            @Override
            public Void execute( Transaction tx ){
                Result result = tx.run("MATCH (a:Examen),(b:Clase) WHERE a.id =$id AND b.id =$idClase CREATE (a)-[r:EXAMEN_DE]->(b) RETURN r", parameters( "id", id, "idClase", idClase));
                return null;   
            }});
            return session.readTransaction( new TransactionWork<Boolean>(){
            @Override
            public Boolean execute( Transaction tx ){
                Result result = tx.run("MATCH (p:Clase)<-[:APLICADO_EN]-(c:Pregunta) WITH p,count(c) as cont WHERE p.id=$idClase RETURN cont >= $nump ",parameters("idClase",idClase,"nump",nump));                
                return result.single().get(0).asBoolean()  ;         
            }});
            
    }
    
    }
    
    /*TRAER USERS*/
    public Object[] UserPass(){
    try ( Session session = driver.session() ){
        return session.readTransaction( new TransactionWork<Object[]>(){
            @Override
            public Object[] execute( Transaction tx ){
                List<Record> result = tx.run("MATCH (a:Alumno) RETURN a.usuario,a.password,a.nombre,a.id").list();
                Object values[];
                values=result.toArray();
                return values;         
            }});
    }
    }
   
    /*TRAER CLASES*/
    public Object[] TraerClases(){
        try ( Session session = driver.session() ){
            return session.readTransaction( new TransactionWork<Object[]>(){
                @Override
                public Object[] execute( Transaction tx ){
                    List<Record> result = tx.run("MATCH (c:Clase) RETURN c.id,c.nombre").list();
                    Object values[];
                    values=result.toArray();
                    return values;          
        }});
    }
    }
    
    /*TRAER TODAS LAS PREGUNTAS DE UNA CLASE*/
     public Object[] TraerPreguntas(final int id){
        try ( Session session = driver.session() ){
            return session.readTransaction( new TransactionWork<Object[]>(){
                @Override
                public Object[] execute( Transaction tx ){
                   List<Record> result = tx.run("MATCH (Clase {id:$id})<-[:APLICADO_EN]-(f) RETURN f.descripcion,f.titulo,f.id,f.idClase",parameters("id",id)).list();
                    Object values[];
                    values=result.toArray();
                    return values;           
        }});
    }
    }
     
     /*TRAER TODAS LOS EXAMENES DE UNA CLASE*/
     public Object[] TraerExame(final int id){
        try ( Session session = driver.session() ){
            return session.readTransaction( new TransactionWork<Object[]>(){
                @Override
                public Object[] execute( Transaction tx ){
                   List<Record> result = tx.run("MATCH (Clase {id:$id})<-[:EXAMEN_DE]-(f) RETURN f.id,f.idClase,f.nump",parameters("id",id)).list();
                    Object values[];
                    values=result.toArray();
                    return values;           
        }});
    }
    }

}