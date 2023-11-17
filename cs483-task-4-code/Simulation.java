//=============================================================================================================================================================
/**
 * Defines the simulation.
 *
 * CHANGE ANYTHING YOU WANT HERE.
 */
public class Simulation {
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public static void main(final String[] arguments) {
      Simulation simulation = new Simulation();

      simulation.doTest();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void doTest() {
      int testNum = -11;

      switch (testNum) {
         case -1:

            doTestArtillery1();

            break;

         case -2:

            doTestBomber1();

            break;

         // add the rest yourself based on which ones you choose to solve
         case -3:

            do_Part1_A();

            break;

         case -4:

            do_Part1_B();

            break;

         case -5:

            do_Part1_C();

            break;

         case -6:

            do_Part1_D();

            break;

         case -7:

            do_Part1_E();

            break;

         case -8:

            par2_A_1();

            break;

         case -9:

            part2_B_1();

            break;

         case -10:

            part2_C_1();

            break;

         case -11:

            part2_D_1();

            break;

         default:

            throw new RuntimeException("bad test " + testNum);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public Simulation() {
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------

   // Boolean function CEP
   private boolean CEP(double distance, double target, double errorRange) {

      double value = Math.abs(Math.abs(distance) - Math.abs(target));

      return (value <= errorRange) ? true : false;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void doTestArtillery1() {
      // runs 1000 tests
      double expectedX = 1348.7351190199681;

      int numRuns = 1000;

      double timeStep = 0.01;

      double sumX = 0;

      System.out.println("run,range");

      for (int iRun = 1; iRun <= numRuns; iRun++) {
         Artillery artillery = new Artillery(75, 500, iRun, 0, 0, 0, 0, 0, 0, 0, false);

         boolean isDone = false;

         while (!isDone) {
            isDone = artillery.update(timeStep);
         }

         double finalX = artillery.getX();

         // System.out.println(iRun + "," + finalX);

         sumX += finalX;
      }

      double average = (sumX / (double) numRuns);
      double averageError = (average - expectedX);

      System.out.println("average       = " + average);
      System.out.println("average_error = " + averageError);
   }

   // Part 1: A.1
   private void do_Part1_A() {
      // runs 1000 tests
      double expectedX = 5000;

      int numRuns = 1000;

      // Numbers after timeStep_x represents each task in Part 1-A
      double timeStep = 0.01;
      double timeStep_4 = 0.1;
      double timeStep_5 = 0.001;

      double sumX = 0;

      System.out.println("run,range");

      for (int iRun = 1; iRun <= numRuns; iRun++) {

         // Number after arillery_x respresnts each task in Part 1-A
         Artillery artillery_1 = new Artillery(69.96, 500, iRun, 0, 0, 0, 0, 0, 0, 0, false);
         Artillery artillery_2 = new Artillery(20, 500, iRun, 0, 0, 0, 0, 0, 0, 0, false);
         boolean isDone = false;

         while (!isDone) {
            isDone = artillery_1.update(timeStep);
         }

         double finalX = artillery_1.getX();
         double finalY = artillery_1.getY();

         System.out.println(iRun + "," + finalY);

         sumX += finalX;
      }

      double average = (sumX / (double) numRuns);
      double averageError = (average - expectedX);

      System.out.println("average       = " + average);
      System.out.println("average_error = " + averageError);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------

   private void do_Part1_B() {
      // runs 1000 tests
      double expectedX = 5000;

      int numRuns = 1000;

      double timeStep = 0.01;

      double sumX = 0;

      double numberOfHits = 0;

      System.out.println("run,range");

      for (int iRun = 1; iRun <= numRuns; iRun++) {

         // Number after arillery_x respresnts each task in Part 1-A
         Artillery artillery_1 = new Artillery(69.96, 500, iRun, 0.52, 0, 0, 0, 0, 0, 0, false);
         Artillery artillery_2 = new Artillery(69.96, 500, iRun, 0, 6.65, 0, 0, 0, 0, 0, false);
         boolean isDone = false;

         while (!isDone) {
            isDone = artillery_2.update(timeStep);
         }

         double finalX = artillery_2.getX();

         boolean cep_value = CEP(finalX, expectedX, 100);

         if (cep_value) {
            numberOfHits += 1.0;
         }

         sumX += finalX;
      }

      double cep = (numberOfHits / (double) numRuns);
      double average = (sumX / (double) numRuns);
      double averageError = (average - expectedX);

      if (cep >= 0.5) {
         System.out.println("CEP STATUS: SUCCESS");
         System.out.println(cep);
      } else {
         System.out.println("CEP STATUS: FAIL");
         System.out.println(cep);
      }

      System.out.println("average       = " + average);
      System.out.println("average_error = " + averageError);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------

   private void do_Part1_C() {
      // runs 1000 tests
      double expectedX = 5000;

      int numRuns = 1000;

      double timeStep = 0.01;

      double sumX = 0;

      double numberOfHits = 0;

      System.out.println("run,range");

      for (int iRun = 1; iRun <= numRuns; iRun++) {

         // Number after arillery_x respresnts each task in Part 1-A
         Artillery artillery_1 = new Artillery(69.96, 500, iRun, 0, 0, 2.62, 0, 0, 0, 0, false);
         Artillery artillery_2 = new Artillery(69.96, 500, iRun, 0, 0, 0, 7.61, 0, 0, 0, false);
         boolean isDone = false;

         while (!isDone) {
            isDone = artillery_2.update(timeStep);
         }

         double finalX = artillery_2.getX();

         boolean cep_value = CEP(finalX, expectedX, 100);

         if (cep_value) {
            numberOfHits += 1.0;
         }

         sumX += finalX;
      }

      double cep = (numberOfHits / (double) numRuns);
      double average = (sumX / (double) numRuns);
      double averageError = (average - expectedX);

      if (cep >= 0.5) {
         System.out.println("CEP STATUS: SUCCESS");
         System.out.println(cep);
      } else {
         System.out.println("CEP STATUS: FAIL");
         System.out.println(cep);
      }

      System.out.println("average       = " + average);
      System.out.println("average_error = " + averageError);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------

   private void do_Part1_D() {
      // runs 1000 tests
      double expectedX = 7767.56799133401;

      int numRuns = 1000;

      double timeStep = 0.01;

      double sumX = 0;

      double numberOfHits = 0;

      System.out.println("run,range");

      for (int iRun = 1; iRun <= numRuns; iRun++) {

         // Number after arillery_x respresnts each task in Part 1-A
         Artillery artillery_1 = new Artillery(45, 500, iRun, 0, 0, 0, 0, 0, 0, 0, false);
         Artillery artillery_2 = new Artillery(45, 500, iRun, 2, 2, 2, 2, 0, 0, 0, false);
         boolean isDone = false;

         while (!isDone) {
            isDone = artillery_2.update(timeStep);
         }

         double finalX = artillery_2.getX();

         boolean cep_value = CEP(finalX, expectedX, 100);

         if (cep_value) {
            numberOfHits += 1.0;
         }

         sumX += finalX;
      }

      double cep = (numberOfHits / (double) numRuns);
      double average = (sumX / (double) numRuns);
      double averageError = (average - expectedX);

      if (cep >= 0.5) {
         System.out.println("CEP STATUS: SUCCESS");
         System.out.println(cep);
      } else {
         System.out.println("CEP STATUS: FAIL");
         System.out.println(cep);
      }

      System.out.println("average       = " + average);
      System.out.println("average_error = " + averageError);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------

   private void do_Part1_E() {
      // runs 1000 tests
      double expectedX = 5000;

      int numRuns = 1000;

      double timeStep = 0.01;

      double sumX = 0;

      double numberOfHits = 0;

      System.out.println("run,range");

      for (int iRun = 1; iRun <= numRuns; iRun++) {

         // Number after arillery_x respresnts each task in Part 1-A
         Artillery artillery = new Artillery(69.96, 500, iRun, 0, 0, 0, 0, 0, -15, -15, false);
         boolean isDone = false;

         while (!isDone) {
            isDone = artillery.update(timeStep);
         }

         double finalX = artillery.getX();

         boolean cep_value = CEP(finalX, expectedX, 100);

         if (cep_value) {
            numberOfHits += 1.0;
         }

         sumX += finalX;
      }

      double cep = (numberOfHits / (double) numRuns);
      double average = (sumX / (double) numRuns);
      double averageError = (average - expectedX);

      if (cep >= 0.5) {
         System.out.println("CEP STATUS: SUCCESS");
         System.out.println(cep);
      } else {
         System.out.println("CEP STATUS: FAIL");
         System.out.println(cep);
      }

      System.out.println("average       = " + average);
      System.out.println("average_error = " + averageError);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void doTestBomber1() {
      double timeStep = 0.01;

      Bomber bomber = new Bomber(500, 500, 0, 0, 0, 0, 0, true);

      boolean isDone = false;

      while (!isDone) {
         isDone = bomber.update(timeStep);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------

   private void par2_A_1() {
      double timeStep = 0.01;

      Bomber bomber = new Bomber(1000, 600, 0, 0, 0, 0, 0, true);

      boolean isDone = false;

      while (!isDone) {
         isDone = bomber.update(timeStep);
      }

      double finalX = bomber.getBombX();

      System.out.println("Final x coordinates: " + finalX);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------

   private void part2_B_1() {
      double timeStep = 0.01;

      double target = 3945;

      Bomber bomber = new Bomber(1000, 500, 0, 65.30, 0, 0, 0, true);

      boolean isDone = false;

      while (!isDone) {
         isDone = bomber.update(timeStep);
      }

      double finalX = bomber.getBombX();

      boolean cep_value = CEP(finalX, target, 100);

      if (cep_value) {
         System.out.println("CEP STATUS: SUCCESS");
      } else {
         System.out.println("CEP STATUS: FAIL");
      }

      System.out.println("Final x coordinates: " + finalX);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------

   private void part2_C_1() {
      double timeStep = 0.01;

      double target = 3945;

      Bomber bomber = new Bomber(1000, 500, 0, 0, 0, 0, 0.94, true);

      boolean isDone = false;

      while (!isDone) {
         isDone = bomber.update(timeStep);
      }

      double finalX = bomber.getBombX();

      boolean cep_value = CEP(finalX, target, 100);

      if (cep_value) {
         System.out.println("CEP STATUS: SUCCESS");
      } else {
         System.out.println("CEP STATUS: FAIL");
      }

      System.out.println("Final x coordinates: " + finalX);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------

   private void part2_D_1() {
      double timeStep = 0.01;

      int numRuns = 1000;

      double target = 3884.112;

      double numberOfHits = 0;

      double sumX = 0;

      for (int iRun = 1; iRun < numRuns; iRun++) {

         Bomber bomber = new Bomber(1200, 450, 0, 5, 5, 5, 5, true);

         boolean isDone = false;

         while (!isDone) {
            isDone = bomber.update(timeStep);
         }
         double finalX = bomber.getBombX();

         sumX += finalX;

         boolean cep_value = CEP(finalX, target, 100);

         if (cep_value) {
            numberOfHits++;
         }
      }

      double cep = (numberOfHits / (double) numRuns);
      double average = (sumX / (double) numRuns);
      double averageError = (average - target);

      if (cep >= 0.5) {
         System.out.println("CEP STATUS: SUCCESS");
      } else {
         System.out.println("CEP STATUS: FAIL");
      }

      System.out.println("average       = " + average);
      System.out.println("average_error = " + averageError);

   }
}
