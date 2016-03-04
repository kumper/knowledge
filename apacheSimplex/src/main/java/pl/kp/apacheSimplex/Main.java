package pl.kp.apacheSimplex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.math3.optim.MaxIter;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

public class Main {

	public static void main(String[] args) {
		//Zad1
		LinearObjectiveFunction f = new LinearObjectiveFunction(new double[] { -2, 1.5, 0, -1 }, 0);
		Collection<LinearConstraint> constraints = new ArrayList<LinearConstraint>();
		constraints.add(new LinearConstraint(new double[] { 4, 2, 4, 0 }, Relationship.LEQ, 4));
		constraints.add(new LinearConstraint(new double[] { 0.5, 0.125, 1, 4 }, Relationship.LEQ, 1));
		constraints.add(new LinearConstraint(new double[] { -10.5, 0.5, -9, -3 }, Relationship.LEQ, 2));

		SimplexSolver solver = new SimplexSolver();

		PointValuePair solution = solver.optimize(
				new MaxIter(100000),
				f, 
				new LinearConstraintSet(constraints), 
				GoalType.MINIMIZE, 
				new NonNegativeConstraint(true)
				);

		System.out.println();
		System.out.println(Arrays.toString(solution.getPoint()));
		System.out.println("min= " + solution.getValue());
		System.out.println("After " + solver.getIterations() + " iterations");
		
		//Zad2
		LinearObjectiveFunction f2 = new LinearObjectiveFunction(new double[]{0, 1, -3, 0, 2}, 0);
		Collection<LinearConstraint> constraints2 = new ArrayList<LinearConstraint>();
		constraints2.add(new LinearConstraint(new double[]{1, 3, -1, 0, 2}, Relationship.EQ, 7));
		constraints2.add(new LinearConstraint(new double[]{0, -2, 4, 1, 0}, Relationship.EQ, 12));
		constraints2.add(new LinearConstraint(new double[]{0, -4, 3, 0, 8}, Relationship.LEQ, 10));
		
		solution = solver.optimize(
				f2,
				new LinearConstraintSet(constraints2),
				GoalType.MINIMIZE,
				new NonNegativeConstraint(true),
				new MaxIter(100000));

		System.out.println();
		System.out.println(Arrays.toString(solution.getPoint()));
		System.out.println("min= " + solution.getValue());
		System.out.println("After " + solver.getIterations() + " iterations");
		
		//Zad3
		LinearObjectiveFunction f3 = new LinearObjectiveFunction(new double[]{6,15,32}, 0);
		Collection<LinearConstraint> constraints3 = new ArrayList<LinearConstraint>();
		constraints3.add(new LinearConstraint(new double[]{5,12,30}, Relationship.LEQ, 100));
		constraints3.add(new LinearConstraint(new double[]{0,1,0}, Relationship.LEQ, 5));
		
		solution = solver.optimize(
				f3,
				new LinearConstraintSet(constraints3),
				GoalType.MAXIMIZE,
				new NonNegativeConstraint(true),
				new MaxIter(100000));

		System.out.println();
		System.out.println(Arrays.toString(solution.getPoint()));
		System.out.println("max= " + solution.getValue());
		System.out.println("After " + solver.getIterations() + " iterations");
		
		
	}
}
