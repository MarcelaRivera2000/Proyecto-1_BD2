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

public class Neo4jCo implements AutoCloseable {

    private final Driver driver;

    public Neo4jCo(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    public void close() throws Exception {
        driver.close();
    }

    /*CREAR ALUMNO*/
    public long addAlumno(final String name, final int id, final String user, final String pass) {
        try ( Session session = driver.session()) {
            session.writeTransaction(new TransactionWork<Void>() {
                @Override
                public Void execute(Transaction tx) {
                    tx.run("CREATE (a:Alumno{nombre:$nombre, id:$id, password:$pass, usuario:$usuario})", parameters("nombre", name, "id", id, "pass", pass, "usuario", user));
                    return null;
                }
            });

        }
        return 0;
    }

    /*CREAR CLASE*/
    public long addClase(final String name, final int id) {
        try ( Session session = driver.session()) {
            session.writeTransaction(new TransactionWork<Void>() {
                @Override
                public Void execute(Transaction tx) {
                    tx.run("CREATE (c:Clase{nombre:$nombre, id:$id})", parameters("nombre", name, "id", id));
                    return null;
                }
            });
        }
        return 0;
    }

    /*CREAR PREGUNTAS*/
    public long addPregunta(final String titulo, final int id, final String descripcion, final int idClase, final boolean respuesta) {
        try ( Session session = driver.session()) {
            session.writeTransaction(new TransactionWork<Void>() {
                @Override
                public Void execute(Transaction tx) {
                    return createPregunta(tx, titulo, id, descripcion, idClase, respuesta);
                }
            });
            session.writeTransaction(new TransactionWork<Void>() {
                @Override
                public Void execute(Transaction tx) {
                    Result result = tx.run("MATCH (a:Pregunta),(b:Clase) WHERE (a.idClase=$idClase) = (b.id=$id ) and a.descripcion=$descripcion CREATE (a)-[r:PREGUNTA_DE]->(b) RETURN r", parameters("id", idClase, "idClase", idClase, "descripcion", descripcion));
                    return null;

                }
            });

        }
        return 0;

    }

    private static Void createPregunta(Transaction tx, String titulo, int id, String descripcion, int idClase, boolean respuesta) {
        tx.run("CREATE (p:Pregunta{titulo:$titulo, id:$id, idClase:$idClase, descripcion:$descripcion,respuesta:$respuesta})", parameters("titulo", titulo, "id", id, "idClase", idClase, "descripcion", descripcion, "respuesta", respuesta));
        return null;
    }

    /*CREAR EXAMENES*/
    public void addExamen(final int id, final int nump, final int idClase) {
        try ( Session session = driver.session()) {
            session.writeTransaction(new TransactionWork<Void>() {
                @Override
                public Void execute(Transaction tx) {
                    JOptionPane.showMessageDialog(null,"ESTO:1");
                    tx.run("CREATE (p:Examen{id:$id, idClase:$idClase, nump:$nump}) return p.nump", parameters("id", id, "nump", nump, "idClase", idClase));
                    return null;
                }
            });
            session.writeTransaction(new TransactionWork<Void>() {
                @Override
                public Void execute(Transaction tx) {
                    JOptionPane.showMessageDialog(null,"ESTO:2");
                    Result result = tx.run("MATCH (a:Examen),(b:Clase) WHERE(a.idClase=$idClase) = (b.id=$id ) and a.nump=$nump  CREATE (a)-[r:EXAMEN_DE]->(b) RETURN r", parameters("id", idClase, "idClase", idClase, "nump", nump));
                    return null;
                }
            });
        }
    }
    
    /*VERIFICA SI HAY ESA CANTIDAD DE PREGUNTAS*/
    public Object[] Verifica(final int id, final int nump, final int idClase) {
        try ( Session session = driver.session()) {
            return session.readTransaction(new TransactionWork<Object[]>() {
                @Override
                public Object[] execute(Transaction tx) {
                    List<Record> result = tx.run("MATCH (p:Clase)<-[:PREGUNTA_DE]-(c:Pregunta) WITH p,count(c) as cont WHERE p.id=$idClase RETURN cont >= $nump ", parameters("idClase", idClase, "nump", nump)).list();
                    Object values[] = result.toArray();
                    return values;
                }
            });
        }
    }

    /*TRAER USERS*/
    public Object[] UserPass() {
        try ( Session session = driver.session()) {
            return session.readTransaction(new TransactionWork<Object[]>() {
                @Override
                public Object[] execute(Transaction tx) {
                    List<Record> result = tx.run("MATCH (a:Alumno) RETURN a.usuario,a.password,a.nombre,a.id").list();
                    Object values[];
                    values = result.toArray();
                    return values;
                }
            });
        }
    }

    /*TRAER CLASES*/
    public Object[] TraerClases() {
        try ( Session session = driver.session()) {
            return session.readTransaction(new TransactionWork<Object[]>() {
                @Override
                public Object[] execute(Transaction tx) {
                    List<Record> result = tx.run("MATCH (c:Clase) RETURN c.id,c.nombre").list();
                    Object values[];
                    values = result.toArray();
                    return values;
                }
            });
        }
    }

    /*TRAER TODAS LAS PREGUNTAS DE UNA CLASE*/
    public Object[] TraerPreguntas(final int id) {
        try ( Session session = driver.session()) {
            return session.readTransaction(new TransactionWork<Object[]>() {
                @Override
                public Object[] execute(Transaction tx) {
                    List<Record> result = tx.run("MATCH (Clase {id:$id})<-[:PREGUNTA_DE]-(f) RETURN f.descripcion,f.titulo,f.id,f.idClase,f.respuesta", parameters("id", id)).list();
                    Object values[];
                    values = result.toArray();
                    return values;
                }
            });
        }
    }

    /*TRAER TODAS LOS EXAMENES DE UNA CLASE*/
    public Object[] TraerExame(final int id) {
        try ( Session session = driver.session()) {
            return session.readTransaction(new TransactionWork<Object[]>() {
                @Override
                public Object[] execute(Transaction tx) {
                    List<Record> result = tx.run("MATCH (Clase {id:$id})<-[:EXAMEN_DE]-(f) RETURN f.id,f.idClase,f.nump", parameters("id", id)).list();
                    Object values[];
                    values = result.toArray();
                    return values;
                }
            });
        }
    }

    /*TRAER TODOS LOS RESULTADOS DEL ALUMNO*/
    public Object[] TraerExame3(final int idestudiante) {
        try ( Session session = driver.session()) {
            return session.readTransaction(new TransactionWork<Object[]>() {
                @Override
                public Object[] execute(Transaction tx) {
                    List<Record> result = tx.run("MATCH (Alumno {id:$id})-[:RESULTADOS]->(f) RETURN f.idEstudiante,f.idExamen,f.Nota,f.idClase", parameters("id", idestudiante)).list();
                    Object values[];
                    values = result.toArray();
                    return values;
                }
            });
        }
    }

    /*TRAER TODOS LOS EXAMENES*/
    public Object[] TraerExames() {
        try ( Session session = driver.session()) {
            return session.readTransaction(new TransactionWork<Object[]>() {
                @Override
                public Object[] execute(Transaction tx) {
                    List<Record> result = tx.run("match (a:Examen) return a.id,a.idClase,a.nump").list();
                    Object values[] = result.toArray();
                    return values;
                }
            });
        }
    }


    /*CREAR RESULTADO*/
    public Void addResultado(final int idExamen, final int idClase, final int idEstudiante,int nota) {
        try ( Session session = driver.session()) {
            session.writeTransaction(new TransactionWork<Void>() {
                @Override
                public Void execute(Transaction tx) {
                    tx.run(" create(t:Resultado{idExamen:$idExamen,idEstudiante:$idEstudiante,Nota:$nota,idClase:$idClase})", parameters("idExamen", idExamen, "idEstudiante", idEstudiante, "nota", nota,"idClase",idClase));
                    return null;
                }
            });
            session.writeTransaction(new TransactionWork<Void>() {
                @Override
                public Void execute(Transaction tx) {
                    Result result = tx.run("MATCH (a:Alumno{id:$idEstudiante}),(b:Resultado{idEstudiante:$idEstudiante}) WHERE a.id = b.idEstudiante CREATE (a)-[r:RESULTADOS]->(b) RETURN r", parameters("id", idEstudiante, "idEstudiante",idEstudiante));
                    return null;
                }
            });
            return session.writeTransaction(new TransactionWork<Void>() {
                @Override
                public Void execute(Transaction tx) {
                    Result result = tx.run("MATCH (a:Resultado{idExamen:$idExamen,idClase:$idClase}),(b:Examen{id:$id,idClase:$idClaseE}) WHERE a.idExamen = b.id and a.idClase=b.idClase CREATE (a)-[r:RESULTADOS_DE]->(b) RETURN r", parameters("idExamen", idExamen, "idClase", idClase,"id",idExamen,"idClaseE",idClase));
                    return null;
                }
            });

        }
    }
    /*
     create(t:Resultado{idExamen:1,idEstudiante:1,Nota:25})
     MATCH (a:Alumno),(b:Resultado) WHERE a.id = b.idEstudiante CREATE (a)-[r:RESULTADOS]->(b) RETURN r
     MATCH (a:Resultado),(b:Examen) WHERE a.idExamen = b.id and a.idClase=b.idClase CREATE (a)-[r:RESULTADOS_DE]->(b) RETURN r
     
     */
}
