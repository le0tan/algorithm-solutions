#include <cstdio>
#include <vector>
#include <cmath>
using namespace std;

vector<double> gauss(vector<vector<double>> A)
{
    int n = A.size();

    for (int i = 0; i < n; i++)
    {
        // Search for maximum in this column
        double maxEl = abs(A[i][i]);
        int maxRow = i;
        for (int k = i + 1; k < n; k++)
        {
            if (abs(A[k][i]) > maxEl)
            {
                maxEl = abs(A[k][i]);
                maxRow = k;
            }
        }

        // Swap maximum row with current row (column by column)
        for (int k = i; k < n + 1; k++)
        {
            double tmp = A[maxRow][k];
            A[maxRow][k] = A[i][k];
            A[i][k] = tmp;
        }

        // Make all rows below this one 0 in current column
        for (int k = i + 1; k < n; k++)
        {
            double c = -A[k][i] / A[i][i];
            for (int j = i; j < n + 1; j++)
            {
                if (i == j)
                {
                    A[k][j] = 0;
                }
                else
                {
                    A[k][j] += c * A[i][j];
                }
            }
        }
    }

    // Solve equation Ax=b for an upper triangular matrix A
    vector<double> x(n);
    for (int i = n - 1; i >= 0; i--)
    {
        x[i] = A[i][n] / A[i][i];
        for (int k = i - 1; k >= 0; k--)
        {
            A[k][n] -= A[k][i] * x[i];
        }
    }
    return x;
}

int main()
{
    double pts[4][3];
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            scanf("%lf", &pts[i][j]);
        }
    }
    double a1 = pts[0][0], a2 = pts[0][1], a3 = pts[0][2];
    double b1 = pts[1][0], b2 = pts[1][1], b3 = pts[1][2];
    double c1 = pts[2][0], c2 = pts[2][1], c3 = pts[2][2];
    double d1 = pts[3][0], d2 = pts[3][1], d3 = pts[3][2];

    // Solve for the outer center of triangle ABC
    int n = 3;
    vector<double> line(n + 1, 0);
    vector<vector<double>> A(n, line);
    vector<double> x(n);
    A[0] = {2 * (a1 - b1), 2 * (a2 - b2), 2 * (a3 - b3), a1 * a1 + a2 * a2 + a3 * a3 - b1 * b1 - b2 * b2 - b3 * b3};
    A[1] = {2 * (a1 - c1), 2 * (a2 - c2), 2 * (a3 - c3), a1 * a1 + a2 * a2 + a3 * a3 - c1 * c1 - c2 * c2 - c3 * c3};
    A[2] = {1, 1, 1, 1}; // This is arbitrary.
    x = gauss(A);
    double q1 = x[0], q2 = x[1], q3 = x[2];

    // Solve for the normal vector
    for (int i = 0; i < 2; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            A[i][j] = pts[i][j] - pts[i + 1][j];
        }
        A[i][3] = 0;
    }
    A[2] = {1, 1, 1, 1}; // This is arbitrary.
    x = gauss(A);

    // Solve for the center of sphere
    double p1 = x[0], p2 = x[1], p3 = x[2];
    int m = 4;
    vector<double> lline(m + 1, 0);
    vector<vector<double>> B(m, lline);
    vector<double> xx(m);
    B[0] = {1, 0, 0, -p1, q1};
    B[1] = {0, 1, 0, -p2, q2};
    B[2] = {0, 0, 1, -p3, q3};
    B[3] = {2 * (a1 - d1), 2 * (a2 - d2), 2 * (a3 - d3), 0, a1 * a1 + a2 * a2 + a3 * a3 - d1 * d1 - d2 * d2 - d3 * d3};
    xx = gauss(B);
    for (int i = 0; i < xx.size() - 1; i++)
        printf("%lf ", xx[i]);

    return 0;
}