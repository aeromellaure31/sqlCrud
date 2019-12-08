package sqlcrud;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class mongoRetrieve {

    public void mongoRetrieve() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        MongoClient mongo = new MongoClient("localhost", 27017);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String dateStart = sdf.format(date);
        System.out.println("Time Started: " + sdf.format(date));
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
            Date stopDate = new Date();
            SimpleDateFormat newFormat = new SimpleDateFormat("HH:mm:ss");
            String dateStop = newFormat.format(stopDate);
            System.out.println("Time Stop: " + newFormat.format(stopDate));
            try {
                Date oldTime = format.parse(dateStart);
                Date stop = format.parse(dateStop);
                long diff = stop.getTime() - oldTime.getTime();
                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;
                long diffHours = diff / (60 * 60 * 1000) % 24;
                System.out.print("Total time consumed: " + diffHours + " hours, ");
                System.out.print(diffMinutes + " minutes, ");
                System.out.println(diffSeconds + " seconds.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    public void mongoRetrieveOutsideLoop() {
//        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//        try {
//            Date date = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//            String dateStart = sdf.format(date);
//            System.out.println("Time Started: " + sdf.format(date));
//            Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
//            mongoLogger.setLevel(Level.SEVERE);
//            MongoClient mongo = new MongoClient("localhost", 27017);
//            MongoDatabase database = mongo.getDatabase("bigProject");
//            MongoCollection<Document> coll = database.getCollection("project");
////            FindIterable<Document> iterDoc = coll.aggregate({"$avg": "$Column1"});
//            long total = coll.count();
//            System.out.println(total);
//            Date stopDate = new Date();
//            SimpleDateFormat newFormat = new SimpleDateFormat("HH:mm:ss");
//            String dateStop = newFormat.format(stopDate);
//            System.out.println("Time Stop: " + newFormat.format(stopDate));
//            try {
//                Date oldTime = format.parse(dateStart);
//                Date stop = format.parse(dateStop);
//                long diff = stop.getTime() - oldTime.getTime();
//                long diffSeconds = diff / 1000 % 60;
//                long diffMinutes = diff / (60 * 1000) % 60;
//                long diffHours = diff / (60 * 60 * 1000) % 24;
//                System.out.print("Total time consumed: " + diffHours + " hours, ");
//                System.out.print(diffMinutes + " minutes, ");
//                System.out.println(diffSeconds + " seconds.");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } catch (MongoException e) {
//            System.out.println(e);
//        }
//    }
}
