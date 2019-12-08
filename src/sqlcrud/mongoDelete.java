
package sqlcrud;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mongoDelete {
    
    public void delete(){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        MongoClient mongo = new MongoClient("localhost", 27017);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String dateStart = sdf.format(date);
        System.out.println("Time Started: " + sdf.format(date));
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
    
    public void mongoDeleteOutsideLoop() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String dateStart = sdf.format(date);
            System.out.println("Time Started: " + sdf.format(date));
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
        } catch (MongoException e) {
            System.out.println(e);
        } 
    }
}
