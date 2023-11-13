//=============================================================================================================================================================
/**
 * Defines the simulation.
 *
 * CHANGE ANYTHING YOU WANT HERE.
 */
public class Simulation
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public static void main(final String[] arguments)
   {
      Simulation simulation = new Simulation();

      simulation.doTestArtillery1();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void doTest()
   {
      int testNum = -1;
      
      switch (testNum)
      {
         case -1:
        
            doTestArtillery1();
         
            break;
         
         case -2:
         
            doTestBomber1();
         
            break;
         
         // add the rest yourself based on which ones you choose to solve
            
         default:
         
            throw new RuntimeException("bad test "+ testNum);
      }
   }
   
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public Simulation()
   {
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void doTestArtillery1()
   {
      // runs 1000 tests
      double expectedX = 1348.7351190199681;

      int numRuns = 1000;

      double timeStep = 0.01;

      double sumX = 0;
      
      System.out.println("run,range");

      for (int iRun = 1; iRun <= numRuns; iRun++)
      {
         Artillery artillery = new Artillery(85, 500, iRun, 0, 0, 0, 0, 0, 0, 0, false);

         boolean isDone = false;

         while (!isDone)
         {
            isDone = artillery.update(timeStep);
         }
         
         double finalX = artillery.getX(); 

         System.out.println(iRun + "," + finalX);
         
         sumX += finalX;
      }
      
      double average = (sumX / (double) numRuns);
      double averageError = (average - expectedX);
      
      System.out.println("average       = "+ average);
      System.out.println("average_error = "+ averageError);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void doTestBomber1()
   {
      double timeStep = 0.01;

      Bomber bomber = new Bomber(500, 500, 0, 0, 0, 0, 0, true);

      boolean isDone = false;

      while (!isDone)
      {
         isDone = bomber.update(timeStep);
      }
   }
}
