package maze.heuristics;

import maze.core.MazeExplorer;
import search.core.BestFirstHeuristic;

/**
 * Created by josephbenton on 8/27/15.
 */
public class DepthFirst implements BestFirstHeuristic<MazeExplorer> {
    @Override
    public int getDistance(MazeExplorer node, MazeExplorer goal) {
        return -node.getLocation().X();
    }
}
