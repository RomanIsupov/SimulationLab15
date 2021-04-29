package main.java.com.example.simulationlab15;

public class Calculation {

    // This functions finds the determinant of Matrix
    private static double getDeterminant(double[][] matrix)
    {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[2][1] * matrix[1][2])
                - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    // This function finds the solution of system of linear equations using cramer's rule
    public static void findSolution(double[][] system)
    {
        double[][] d = {
                { system[0][0], system[0][1], system[0][2] },
                { system[1][0], system[1][1], system[1][2] },
                { 1.0, 1.0, 1.0 },
        };
        double[][] d1 = {
                { 0.0, system[0][1], system[0][2] },
                { 0.0, system[1][1], system[1][2] },
                { 1.0, 1.0, 1.0 },
        };
        double[][] d2 = {
                { system[0][0], 0.0, system[0][2] },
                { system[1][0], 0.0, system[1][2] },
                { 1.0, 1.0, 1.0 },
        };
        double[][] d3 =
                {
                        { system[0][0], system[0][1], 0.0 },
                        { system[1][0], system[1][1], 0.0 },
                        { 1.0, 1.0, 1.0 },
                };
        double D = getDeterminant(d);
        double D1 = getDeterminant(d1);
        double D2 = getDeterminant(d2);
        double D3 = getDeterminant(d3);

        double x = D1 / D;
        double y = D2 / D;
        double z = D3 / D;
        System.out.println(x + " " + y + " " + z + '\n');
    }
}
