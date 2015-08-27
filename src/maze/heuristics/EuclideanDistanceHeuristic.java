package maze.heuristics;

import maze.core.MazeExplorer;
import search.core.BestFirstHeuristic;

/**
 * Created by Joseph on 8/27/2015.
 */
public class EuclideanDistanceHeuristic implements BestFirstHeuristic<MazeExplorer> {
    @Override
    public int getDistance(MazeExplorer node, MazeExplorer goal) {
        double dx = goal.getLocation().X() - node.getLocation().X();
        double dy = goal.getLocation().X() - node.getLocation().X();
        return (int)Math.sqrt(dx * dx + dy * dy);
    }
}
