package planner.heuristics;

import planner.core.Plan;
import planner.core.PlanGraph;
import planner.core.PlanStep;
import search.core.BestFirstHeuristic;

/**
 * Created by josephbenton on 9/8/15.
 */
public class NoDeletePlan implements BestFirstHeuristic<PlanStep> {
    @Override
    public int getDistance(PlanStep node, PlanStep goal) {
        PlanGraph p = new PlanGraph(node.getDomain(), node.getWorldState(), node.getProblem());
        Plan ndp = p.extractNoDeletePlan();
        return ndp.length();

    }
}
