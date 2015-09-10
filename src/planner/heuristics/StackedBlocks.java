package planner.heuristics;

import planner.core.*;
import search.core.BestFirstHeuristic;

import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;

/**
 * Created by josephbenton on 9/10/15.
 */
public class StackedBlocks implements BestFirstHeuristic<PlanStep> {
    @Override
    public int getDistance(PlanStep node, PlanStep goal) {
        State s = node.getWorldState();
        HashMap<String, String> stackDict = new HashMap<>();
        for (Predicate p : s) {
            if (p.getName().contains("stack")) {
                List<String> params = p.getParams();
                if (params.size() == 2){
                    stackDict.put(params.get(0), params.get(1));
                }
            }
        }
        Action a = node.getGeneratingAction();
        if (a.isNamed().contains(""))
        List<String> p = a.getParameters();

        return 0;
    }
}