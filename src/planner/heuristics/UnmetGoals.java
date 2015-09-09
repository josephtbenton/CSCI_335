package planner.heuristics;

import planner.core.PlanStep;
import planner.core.State;
import search.core.BestFirstHeuristic;

/**
 * Created by josephbenton on 9/8/15.
 */
public class UnmetGoals implements BestFirstHeuristic<PlanStep> {

    @Override
    public int getDistance(PlanStep node, PlanStep goal) {
        return node.getWorldState().unmetGoals(goal.getWorldState()).size();
    }
}
