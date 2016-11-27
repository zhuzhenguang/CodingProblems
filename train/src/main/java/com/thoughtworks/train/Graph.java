package com.thoughtworks.train;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Graph
 * <p>
 * Created by napoleon on 29/10/2016.
 */
public class Graph {
    private static Graph graph;
    private List<Section> sectionsInGraph;

    static void initialize(String graphPath) {
        if (graph == null) {
            graph = new Graph(graphPath);
        }
    }

    public static Graph instance() {
        return graph;
    }

    private Graph(String graphPath) {
        sectionsInGraph = new ArrayList<>();
        initializeSections(graphPath);
    }

    private void initializeSections(String graphPath) {
        String[] sectionPaths = graphPath.split(", ");
        for (String sectionPath : sectionPaths) {
            String start = String.valueOf(sectionPath.charAt(0));
            String end = String.valueOf(sectionPath.charAt(1));
            int distance = Character.getNumericValue(sectionPath.charAt(2));
            sectionsInGraph.add(new Section(start, end, distance));
        }
    }

    int getDistanceOf(Section section) {
        for (Section sectionInGraph : sectionsInGraph) {
            if (sectionInGraph.equals(section)) {
                return sectionInGraph.distance();
            }
        }
        throw new NoSuchRouteException("NO SUCH ROUTE");
    }

    public List<Section> sectionsStartWith(String start) {
        List<Section> collect = sectionsInGraph.stream().filter(section -> section.startWith(start)).collect(Collectors.toList());
        return cloneFrom(collect);
    }

    public List<Section> sectionsFrom(Section previousSection) {
        List<Section> sections = sectionsStartWith(previousSection.end());
        sections.forEach(section -> section.setPreviousSection(previousSection));
        return sections;
    }

    private static List<Section> cloneFrom(List<Section> collect) {
        List<Section> results = new ArrayList<>();
        for (Section section : collect) {
            try {
                results.add((Section) section.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
