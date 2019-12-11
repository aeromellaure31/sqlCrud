package sqlcrud;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mongoRetrieve {

    public void mongoRetrieve() {
        double start = System.currentTimeMillis();
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        MongoClient mongo = new MongoClient("localhost", 27017);
        float col1 = 0;
        float col2 = 0;
        float col3 = 0;
        float col4 = 0;
        float col5 = 0;
        try {
            MongoDatabase database = mongo.getDatabase("bigProject");
            MongoCollection<Document> coll = database.getCollection("project");

            FindIterable<Document> iterDoc = coll.find();
            for (Document doc : iterDoc) {
                String s1 = doc.get("Column1").toString();
                String s2 = doc.get("Column2").toString();
                String s3 = doc.get("Column3").toString();
                String s4 = doc.get("Column4").toString();
                String s5 = doc.get("Column5").toString();
                col1 += Float.parseFloat(s1);
                col2 += Float.parseFloat(s2);
                col3 += Float.parseFloat(s3);
                col4 += Float.parseFloat(s4);
                col5 += Float.parseFloat(s5);
            }
            System.out.println(col1 / 1000);
            System.out.println(col2 / 1000);
            System.out.println(col3 / 1000);
            System.out.println(col4 / 1000);
            System.out.println(col5 / 1000);
            long total = coll.count();
            System.out.println(total);
        } catch (MongoException e) {
            System.out.println(e);
        } finally {
            mongo.close();
            double stop = System.currentTimeMillis();
            System.out.println(stop);
            double timeConsumed = (stop - start) / 1000;
            System.out.println("Total time consumed: " + timeConsumed + " seconds");
        }
    }

//    public void mongoRetrieveOutsideLoop() {
//        double start = System.currentTimeMillis();
//        try {
//            Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
//            mongoLogger.setLevel(Level.SEVERE);
//            MongoClient mongo = new MongoClient("localhost", 27017);
//            MongoDatabase database = mongo.getDatabase("bigProject");
//            MongoCollection<Document> coll = database.getCollection("project");
//            //            FindIterable<Document> iterDoc = coll.aggregate({"$avg": "$Column1"});
//            coll.aggregate([
//            {
//                $group:
//                {
//                    {
//                        $avg:
//                        "$Column1"
//                    }
//                }
//            }]);
//            long total = coll.count();
//            System.out.println(total);
//        } catch (MongoException e) {
//            System.out.println(e);
//        }
//    }
}
