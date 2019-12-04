package sqlcrud;

public class SqlCrud {

    public static void main(String[] args) {
        insert in = new insert();
//        System.out.println("Inserting data INSIDE the loop");
//        in.ins();
//        System.out.println("\nInserting data OUTSIDE the loop");
//        in.anotherTry();
        
        delete del = new delete(); 
        System.out.println("Deleting data INSIDE the loop");
        del.deleteData();
//        System.out.println("Deleting data OUTSIDE the loop");
//        del.delete();
        
        retrieve ret = new retrieve();
//        System.out.println("Retrieving data INSIDE the loop");
//        ret.retrieveData();
//        System.out.println("Retrieving data OUTSIDE the loop");
//        ret.retrieve();
        
        
    }
}
