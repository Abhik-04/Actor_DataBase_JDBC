//STEP 1. Import required packages

import java.sql.*;
import java.util.*;
public class ActorDB_JDBC {

   // Set JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost:3306/JDBCproj?useSSL=false";

   // Database credentials
   static final String USER = "root";// add your user
   static final String PASSWORD = "Almanac@1";// add password

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      Connection conn = null;
      Statement stmt = null;

      // STEP 2. Connecting to the Database
      try {
         // STEP 2a: Register JDBC driver
         Class.forName(JDBC_DRIVER);
         // STEP 2b: Open a connection
         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

         // Set auto commit as false.
         conn.setAutoCommit(false);

         // STEP 2c: Execute a query
         System.out.println("Creating statement...");
         stmt = conn.createStatement();

         // INSERT, UPDATE, DELETE
         //stmt.executeUpdate(createEmployee);

         // STEP 3: Query to database
         System.out.println();
         System.out.println("MENU:");
         System.out.println("1. How much hours an actor has worked?");
         System.out.println("2. Total worth of an Actor.");
         System.out.println("3. Movies above a certain rating.");
         System.out.println("4. Movies below a certain rating.");
         System.out.println("5. All awards an actor has won.");
         System.out.println("6. All actors who have won an award.");
         System.out.println("7. Total awards won by an actor.");
         System.out.println("8. Actors above a certain age.");
         System.out.println("9. Actors below a certain age.");
         System.out.println("10. Name of relations of an actor.");
         System.out.println("11. Add a new Movie.");
         System.out.println("12. Add a new Relation.");
         System.out.println();

         System.out.print("Enter your query choice: ");
         int choice = sc.nextInt();

         if(choice == 1){
            System.out.print("Enter Actor ID: ");
            String x = sc.next();
            String Query1a = "select AC.ActorId, AC.ActorName, SUM(W.Hours) as TotalHours from ACTOR as AC INNER JOIN WORKS_ON as W on AC.ActorId = W.ActorId WHERE AC.ActorId = '" + x + "' GROUP BY(AC.ActorId);";
            ResultSet rs = stmt.executeQuery(Query1a);
            if(x.equals("*")){
               String Query1b = "select AC.ActorId, AC.ActorName, SUM(W.Hours) as TotalHours from ACTOR as AC INNER JOIN WORKS_ON as W on AC.ActorId = W.ActorId GROUP BY(AC.ActorId);";
               rs = stmt.executeQuery(Query1b);
            }

            // STEP 4: Extract data from result set
            while (rs.next()) {

               // Retrieve by column name
               String actorIdResult = rs.getString("ActorId");
               String actorName = rs.getString("ActorName");
               double totalHours = rs.getDouble("TotalHours");

               // Print the results
               System.out.print("Actor ID: " + actorIdResult);
               System.out.print(", Actor Name: " + actorName);
               System.out.println(", Total Hours: " + totalHours);
            }

            // STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }

         if(choice == 2){
            System.out.print("Enter Actor ID: ");
            String x = sc.next();
            String Query2a = "select AC.ActorId, AC.ActorName, SUM(W.Pay) as TotalWorth from ACTOR as AC INNER JOIN WORKS_ON as W on AC.ActorId = W.ActorId WHERE AC.ActorId = '" + x + "' GROUP BY(AC.ActorId);";
            ResultSet rs = stmt.executeQuery(Query2a);
            if(x.equals("*")){
               String Query2b = "select AC.ActorId, AC.ActorName, SUM(W.Pay) as TotalWorth from ACTOR as AC INNER JOIN WORKS_ON as W on AC.ActorId = W.ActorId GROUP BY(AC.ActorId);";
               rs = stmt.executeQuery(Query2b);
            }
            

            // STEP 4: Extract data from result set
            while (rs.next()) {

               // Retrieve by column name
               String actorIdResult = rs.getString("ActorId");
               String actorName = rs.getString("ActorName");
               String totalWorth = rs.getString("TotalWorth");

               // Print the results
               System.out.print("Actor ID: " + actorIdResult);
               System.out.print(", Actor Name: " + actorName);
               System.out.println(", Total Worth: " + totalWorth);
            }

            // STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }

         if(choice == 3){
            System.out.print("Enter rating amount: ");
            Double x = sc.nextDouble();
            String Query3 = "select MovieId, MovieName, Rating from MOVIE where rating > " + x + ";";
            ResultSet rs = stmt.executeQuery(Query3);

            // STEP 4: Extract data from result set
            while (rs.next()) {
               String movieId = rs.getString("MovieId");
               String movieName = rs.getString("MovieName");
               double rating = rs.getDouble("Rating");

               // Print the results
               System.out.print("Movie ID: " + movieId);
               System.out.print(", Movie Name: " + movieName);
               System.out.println(", Rating: " + rating);
            }

            // STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }

         if(choice == 4){
            System.out.print("Enter rating amount: ");
            Double x = sc.nextDouble();
            String Query4 = "select MovieId, MovieName, Rating from MOVIE where rating < " + x + ";";
            ResultSet rs = stmt.executeQuery(Query4);

            // STEP 4: Extract data from result set
            while (rs.next()) {
               String movieId = rs.getString("MovieId");
               String movieName = rs.getString("MovieName");
               double rating = rs.getDouble("Rating");

               // Print the results
               System.out.print("Movie ID: " + movieId);
               System.out.print(", Movie Name: " + movieName);
               System.out.println(", Rating: " + rating);
            }

            // STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }

         if(choice == 5){
            System.out.print("Enter Actor ID: ");
            String x = sc.next();
            String Query5a = "select AC.ActorId, AC.ActorName, AW.AwardId, AW.AwardName, A.TimesWon from ACTOR as AC INNER JOIN AWARDS_WON as A on AC.ActorId = A.ActorId INNER JOIN AWARD as AW on A.AwardId = AW.AwardId WHERE AC.ActorId = '" + x + "' ORDER BY AC.ActorId, AW.AwardId;";
            ResultSet rs = stmt.executeQuery(Query5a);
            if(x.equals("*")){
               String Query5b = "select AC.ActorId, AC.ActorName, AW.AwardId, AW.AwardName, A.TimesWon from ACTOR as AC INNER JOIN AWARDS_WON as A on AC.ActorId = A.ActorId INNER JOIN AWARD as AW on A.AwardId = AW.AwardId ORDER BY AC.ActorId, AW.AwardId;";
               rs = stmt.executeQuery(Query5b);
            }

            // STEP 4: Extract data from result set
            while (rs.next()) {
               String actorIdResult = rs.getString("ActorId");
               String actorName = rs.getString("ActorName");
               String awardId = rs.getString("AwardId");
               String awardName = rs.getString("AwardName");
               int timesWon = rs.getInt("TimesWon");

               // Print the results
               System.out.print("Actor ID: " + actorIdResult);
               System.out.print(", Actor Name: " + actorName);
               System.out.print(", Award ID: " + awardId);
               System.out.print(", Award Name: " + awardName);
               System.out.println(", Times Won: " + timesWon);
            }

            // STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }

         if(choice == 6){
            System.out.print("Enter Award ID: ");
            String x = sc.next();
            String Query6a = "select AW.AwardId, AW.AwardName, AC.ActorId, AC.ActorName from AWARD as AW INNER JOIN AWARDS_WON as A on AW.AwardId = A.AwardId INNER JOIN ACTOR as AC on AC.ActorId = A.ActorId WHERE AW.AwardId = '" + x + "' ORDER BY AW.AwardId, AC.ActorId;";
            ResultSet rs = stmt.executeQuery(Query6a);
            if(x.equals("*")){
               String Query6b = "select AC.ActorId, AC.ActorName, AW.AwardId, AW.AwardName, A.TimesWon from ACTOR as AC INNER JOIN AWARDS_WON as A on AC.ActorId = A.ActorId INNER JOIN AWARD as AW on A.AwardId = AW.AwardId ORDER BY AC.ActorId, AW.AwardId;";
               rs = stmt.executeQuery(Query6b);
            }

            // STEP 4: Extract data from result set
            while (rs.next()) {
               String awardId = rs.getString("AwardId");
               String awardName = rs.getString("AwardName");
               String actorIdResult = rs.getString("ActorId");
               String actorName = rs.getString("ActorName");

               // Print the results
               System.out.print("Award ID: " + awardId);
               System.out.print(", Award Name: " + awardName);
               System.out.print(", Actor ID: " + actorIdResult);
               System.out.println(", Actor Name: " + actorName);
            }

            // STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }

         if(choice == 7){
            System.out.print("Enter Actor ID: ");
            String x = sc.next();
            String Query7a = "select AC.ActorId, AC.ActorName, SUM(A.TimesWon) as TotalAwards from ACTOR as AC INNER JOIN AWARDS_WON as A on AC.ActorId = A.ActorId WHERE AC.ActorId = '" + x + "' GROUP BY(AC.ActorId);";
            ResultSet rs = stmt.executeQuery(Query7a);
            if(x.equals("*")){
               String Query7b = " select AC.ActorId, AC.ActorName, SUM(A.TimesWon) as TotalAwards from ACTOR as AC INNER JOIN AWARDS_WON as A on AC.ActorId = A.ActorId GROUP BY(AC.ActorId);";
               rs = stmt.executeQuery(Query7b);
            }

            // STEP 4: Extract data from result set
            while (rs.next()) {
               String actorIdResult = rs.getString("ActorId");
               String actorName = rs.getString("ActorName");
               int totalAwards = rs.getInt("TotalAwards");

               // Print the results
               System.out.print("Actor ID: " + actorIdResult);
               System.out.print(", Actor Name: " + actorName);
               System.out.println(", Total Awards: " + totalAwards);
            }

            // STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }

         if(choice == 8){
            System.out.print("Enter Actor age: ");
            int x = sc.nextInt();
            String Query8 = "select ActorId, ActorName, ActorAge from ACTOR where ActorAge >" + x + ";";
            ResultSet rs = stmt.executeQuery(Query8);

            // STEP 4: Extract data from result set
            while (rs.next()) {
               String actorIdResult = rs.getString("ActorId");
               String actorName = rs.getString("ActorName");
               int ActorAge = rs.getInt("ActorAge");

               // Print the results
               System.out.print("Actor ID: " + actorIdResult);
               System.out.print(", Actor Name: " + actorName);
               System.out.println(", Actor Age: " + ActorAge);
            }

            // STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }

         if(choice == 9){
            System.out.print("Enter Actor age: ");
            int x = sc.nextInt();
            String Query9 = "select ActorId, ActorName, ActorAge from ACTOR where ActorAge <" + x + ";";
            ResultSet rs = stmt.executeQuery(Query9);

            // STEP 4: Extract data from result set
            while (rs.next()) {
               String actorIdResult = rs.getString("ActorId");
               String actorName = rs.getString("ActorName");
               int ActorAge = rs.getInt("ActorAge");

               // Print the results
               System.out.print("Actor ID: " + actorIdResult);
               System.out.print(", Actor Name: " + actorName);
               System.out.println(", Actor Age: " + ActorAge);
            }

            // STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }

         if(choice == 10){
            System.out.print("Enter Actor ID: ");
            String x = sc.next();
            String Query10a = "select AC.ActorId, AC.ActorName, R.RelationId, R.RelationName, R.RelationType from ACTOR as AC, RELATIONSHIP as R where AC.ActorId = R.ActorId and AC.ActorId = '" + x + "' ORDER BY ActorId;";
            ResultSet rs = stmt.executeQuery(Query10a);
            if(x.equals("*")){
               String Query10b = "select AC.ActorId, AC.ActorName, R.RelationId, R.RelationName, R.RelationType from ACTOR as AC, RELATIONSHIP as R where AC.ActorId = R.ActorId ORDER BY ActorId;";
               rs = stmt.executeQuery(Query10b);
            }

            // STEP 4: Extract data from result set
            while (rs.next()) {
               String actorIdResult = rs.getString("ActorId");
               String actorName = rs.getString("ActorName");
               String relationId = rs.getString("RelationId");
               String relationName = rs.getString("RelationName");
               String relationType = rs.getString("RelationType");

               // Print the results
               System.out.print("Actor ID: " + actorIdResult);
               System.out.print(", Actor Name: " + actorName);
               System.out.print(", Relation ID: " + relationId);
               System.out.print(", Relation Name: " + relationName);
               System.out.println(", Relation Type: " + relationType);
            }

            // STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }

         if(choice == 11){
            System.out.print("Enter Movie ID: ");
            String MovieId = sc.next();

            System.out.print("Enter Movie Name: ");
            String MovieName = sc.next();

            System.out.print("Enter Movie rating: ");
            Double rating = sc.nextDouble();

            System.out.print("Enter Movie Budget: ");
            int Budget = sc.nextInt();

            String Query11a = "INSERT INTO MOVIE VALUES('" + MovieId + "', '" + MovieName + "', " + rating + ", '" + Budget + "cr');";
            stmt.executeUpdate(Query11a);

            System.out.print("Number of Actors to work in the movie: ");
            int n = sc.nextInt();

            String[] actors = new String[n];
            System.out.print("Enter Actor IDs: ");
            for(int i = 0; i<n; i++){
               actors[i] = sc.next();
            }

            Double[] hours = new Double[n];
            System.out.print("Enter hours of work: ");
            for(int i = 0; i<n; i++){
               hours[i] = sc.nextDouble();
            }

            int[] pay = new int[n];
            System.out.print("Enter Actor's pay: ");
            for(int i = 0; i<n; i++){
               pay[i] = sc.nextInt();
            }

            for(int i = 0; i<n; i++){
               String Query11b = "INSERT INTO WORKS_ON VALUES('" + actors[i] + "', '" + MovieId + "', " + hours[i] + ", '" + pay[i] + "cr');";
               stmt.executeUpdate(Query11b);
            }
            

            String[] awards = new String[n];
            System.out.print("Enter awards won by actor for this movie: ");
            for(int i = 0; i<n; i++){
               awards[i] = sc.next();
            }

            //String Query11c = "";
            for(int i = 0; i<n; i++){
               if(awards[i].equals("AW1") || awards[i].equals("AW2") || awards[i].equals("AW3")){
                  String q = "select count(ActorId) as Count from AWARDS_WON where ActorID = '" + actors[i] + "' and AwardId = '" + awards[i] + "';";
                  ResultSet r = stmt.executeQuery(q);
                  r.next();
                  int count = r.getInt("Count");
                  if(count == 0){
                     String Query11c = "INSERT INTO AWARDS_WON VALUES('" + actors[i] + "', '" + awards[i] + "', 1);";
                     stmt.executeUpdate(Query11c);
                  }
                  else{
                     String Query11c = "UPDATE AWARDS_WON SET TimesWon = TimesWon + 1 where ActorID = '" + actors[i] + "' and AwardId = '" + awards[i] + "';";
                     stmt.executeUpdate(Query11c);
                  }
                  r.close();
               }
            }

            conn.commit();

            stmt.close();
            conn.close();
         }

         if(choice == 12){
            System.out.print("Enter Relation ID: ");
            String relationId = sc.next();

            System.out.print("Enter Relation Name: ");
            String relationName = sc.next();

            System.out.print("Enter Relation Type: ");
            String relationType = sc.next();

            String Query12a = "INSERT INTO RELATIONSHIP VALUES(NULL, '" + relationId + "', '" + relationName + "', '" + relationType + "');";
            stmt.executeUpdate(Query12a);

            System.out.print("Enter Actor ID: ");
            String actorId = sc.next();
            String Query12b = "UPDATE RELATIONSHIP SET ActorId = '" + actorId + "' WHERE RelationId = '" + relationId + "';";
            stmt.executeUpdate(Query12b);

            conn.commit();
            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
         }

      } catch (SQLException se) { // Handle errors for JDBC
         se.printStackTrace();
         // If there is an error then rollback the changes.
         System.out.println("Rolling back data here....");
         try{
            if(conn!=null)
                conn.rollback();
         }catch(SQLException se2){
            System.out.println("Rollback failed....");
                 se2.printStackTrace();
         }
      } catch (Exception e) { // Handle errors for Class.forName
         e.printStackTrace();
      } finally { // finally block used to close resources regardless of whether an exception was
                  // thrown or not
         try {
            if (stmt != null)
               stmt.close();
         } catch (SQLException se2) {
         }
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            se.printStackTrace();
         } // end finally try
      } // end try
      System.out.println("End of Code");

      sc.close();
   } // end main
} // end class

// Note : By default autocommit is on. you can set to false using
// con.setAutoCommit(false)
