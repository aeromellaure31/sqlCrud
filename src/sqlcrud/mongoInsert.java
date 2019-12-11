package sqlcrud;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.logging.Level;
import java.util.logging.Logger;

//import java.util.HashMap;
//import java.util.Map;
public class mongoInsert {

    public void mongoInsert() {
        double start = System.currentTimeMillis();
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        MongoClient mongo = new MongoClient("localhost", 27017);
        try {
            MongoDatabase database = mongo.getDatabase("bigProject");
            MongoCollection<Document> coll = database.getCollection("project");

            for (int x = 1; x <= 1000; ++x) {
                Document document = new Document()
                        .append("id", x)
                        .append("Column1", x)
                        .append("Column2", x + 1)
                        .append("Column3", x + 2)
                        .append("Column4", x + 3)
                        .append("Column5", x + 4);
                coll.insertOne(document);
            }
            long total = coll.count();
            System.out.println(total);
        } catch (MongoException e) {
            System.out.println(e);
        } finally {
            mongo.close();
            double stop = System.currentTimeMillis();
            System.out.println(stop);
            double timeConsumed = (stop-start)/1000;
            System.out.println("Total time consumed: " + timeConsumed + " seconds");
        }
    }

    public void mongoInsertOutsideLoop() {
        double start = System.currentTimeMillis();
        try {
            Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);
            for (int x = 1; x <= 1000; ++x) {
                MongoClient mongo = new MongoClient("localhost", 27017);
                MongoDatabase database = mongo.getDatabase("bigProject");
                MongoCollection<Document> coll = database.getCollection("project");
                Document document = new Document()
                        .append("id", x)
                        .append("Column1", x)
                        .append("Column2", x + 1)
                        .append("Column3", x + 2)
                        .append("Column4", x + 3)
                        .append("Column5", x + 4);
                coll.insertOne(document);
//                mongo.close();
                long total = coll.count();
                System.out.println(total);
            }
        } catch (MongoException e) {
            System.out.println(e);
        } finally {
            double stop = System.currentTimeMillis();
            System.out.println(stop);
            double timeConsumed = (stop-start)/1000;
            System.out.println("Total time consumed: " + timeConsumed + " seconds");
        }
    }
}
