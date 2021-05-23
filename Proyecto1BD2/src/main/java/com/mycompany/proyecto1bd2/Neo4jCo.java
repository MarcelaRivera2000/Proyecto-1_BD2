
package com.mycompany.proyecto1bd2;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
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
                return createPersonNode( tx, name,id,user,pass );
            }});
        return session.readTransaction( new TransactionWork<Long>(){
            @Override
            public Long execute( Transaction tx ){
                return matchPersonNode( tx, name ,id,user,pass);
            }});
    }
    }
    
    private static Void createPersonNode( Transaction tx, String name, int id, String user, String pass )
    {
    tx.run( "CREATE (a:Alumno{nombre:$nombre, id:$id, password:$pass, usuario:$usuario})", parameters("nombre", name, "id", id, "pass", pass, "usuario", user) );
    return null;
    }

    private static long matchPersonNode( Transaction tx, String name, int id, String user, String pass )
    {
    Result result = tx.run( "MATCH (a:Alumno{nombre:$nombre, id:$id, password:$pass, usuario:$usuario}) RETURN id(a)", parameters("nombre", name, "id", id, "pass", pass, "usuario", user) );
    return result.single().get( 0 ).asLong();
    }
    
    
    /*CREAR CLASE*/
    public long addClase( final String name,final int id){
    try ( Session session = driver.session() ){
        session.writeTransaction( new TransactionWork<Void>(){
            @Override
            public Void execute( Transaction tx ){
                return createClase( tx, name,id);
            }});
        return session.readTransaction( new TransactionWork<Long>(){
            @Override
            public Long execute( Transaction tx ){
                return matchClase( tx, name ,id);
            }});
    }
    }
    
    private static Void createClase( Transaction tx, String name, int id )
    {
    tx.run( "CREATE (c:Clase{nombre:$nombre, id:$id})", parameters("nombre", name, "id", id) );
    return null;
    }

    private static long matchClase( Transaction tx, String name, int id )
    {
    Result result = tx.run( "MATCH (c:Clase{nombre:$nombre, id:$id}) RETURN id(c)", parameters("nombre", name, "id", id) );
    return result.single().get( 0 ).asLong();
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
                return matchPregunta( tx,id,idClase);
                
            }});
    
    }
        return 0;
   
    }
    
    private static Void createPregunta( Transaction tx, String titulo, int id, String descripcion, int idClase )
    {
    tx.run( "CREATE (p:Pregunta{titulo:$titulo, id:$id, idClase:$idClase, descripcion:$descripcion})", parameters("titulo", titulo, "id", id, "idClase", idClase, "descripcion", descripcion) );
    return null;
    }

    private static Void matchPregunta( Transaction tx, int id, int idClase )
    {
        Result result = tx.run("MATCH (a:Pregunta),(b:Clase) WHERE a.id =$id AND b.id =$idClase CREATE (a)-[r:APLICADO_EN]->(b) RETURN r", parameters( "id", id, "idClase", idClase));
        return null;
    }
    
    /*TRAER USERS*/
    public Object[] UserPass(){
        System.out.println("LO");
    try ( Session session = driver.session() ){
        return session.readTransaction( new TransactionWork<Object[]>(){
            @Override
            public Object[] execute( Transaction tx ){
                return traeUserPass(tx);           
            }});
    }
    }

    private static Object[] traeUserPass( Transaction tx )
    {
    System.out.println("si llega");
    List<Record> result = tx.run("MATCH (a:Alumno) RETURN a.usuario,a.password,a.nombre,a.id").list();
    Object values[];
    values=result.toArray();
    return values;
    }
    
}
   
/*ArrayList<Object> values=new ArrayList();
        for (int i = 0; i < 10; i++) {
            values.add("1");
            
        }
    */
