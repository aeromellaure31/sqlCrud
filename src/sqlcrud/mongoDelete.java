
package sqlcrud;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mongoDelete {
    
    public void delete(){
        double start = System.currentTimeMillis();  
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        MongoClient mongo = new MongoClient("localhost", 27017);
        try {
            MongoDatabase database = mongo.getDatabase("bigProject");
            MongoCollection<Document> coll = database.getCollection("project");
            for (int x = 1; x <= 1000; ++x) {
                coll.deleteOne(Filters.eq("id", x)); 
                System.out.println(coll.deleteOne(Filters.eq("id", x)));
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
    
    public void mongoDeleteOutsideLoop() {
        double start = System.currentTimeMillis();  
        try {
            Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);
            for (int x = 1; x <= 1000; ++x) {
                MongoClient mongo = new MongoClient("localhost", 27017);
                MongoDatabase database = mongo.getDatabase("bigProject");
                MongoCollection<Document> coll = database.getCollection("project");
                coll.deleteOne(Filters.eq("id", x));
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
