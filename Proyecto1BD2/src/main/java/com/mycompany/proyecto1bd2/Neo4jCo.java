
package com.mycompany.proyecto1bd2;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import java.util.ArrayList;
import java.util.List;

import org.neo4j.driver.AccessMode;
import org.neo4j.driver.Record;
import org.neo4j.driver.Session;
import org.neo4j.driver.Result;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Bookmark;

import static org.neo4j.driver.Values.parameters;
import static org.neo4j.driver.SessionConfig.builder;
import org.neo4j.driver.TransactionWork;

public class Neo4jCo implements AutoCloseable{
    private final Driver driver;

    public Neo4jCo( String uri, String user, String password ){
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ));
    }

    public void close() throws Exception{
        driver.close();
    }
    
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
    
}
   

