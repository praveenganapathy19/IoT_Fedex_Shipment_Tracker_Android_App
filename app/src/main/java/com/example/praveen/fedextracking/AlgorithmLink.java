package com.example.praveen.fedextracking;

/**
 * Created by Praveen on 10/09/2017.
 */
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;

import no.wtw.android.dijkstra.DijkstraAlgorithm;
import no.wtw.android.dijkstra.exception.PathNotFoundException;
import no.wtw.android.dijkstra.model.Edge;
import no.wtw.android.dijkstra.model.Graph;
import no.wtw.android.dijkstra.model.Vertex;


public class AlgorithmLink {
    String mainSource,mainDest;

public AlgorithmLink(String source,String dest)
{
    mainSource=source;
    mainDest=dest;
    vertexSource = new Vertex<>(mainSource);
    vertexDest = new Vertex<>(mainDest);

}
    Vertex<String> vertexSource = null;
    Vertex<String> vertexDest = null;

    //returns array list of edge for use in Graph class
    public ArrayList<Edge> funcDefine()
    {

        //defining Vertices
        Vertex<String> vertex1 = new Vertex<>("Northborough, MA");
        Vertex<String> vertex2 = new Vertex<>("Edison, NJ");
        Vertex<String> vertex3 = new Vertex<>("Pittsburgh, PA");
        Vertex<String> vertex4 = new Vertex<>("Allentown, PA");
        Vertex<String> vertex5 = new Vertex<>("Martinsburg, WV");
        Vertex<String> vertex6 = new Vertex<>("Charlotte, NC");
        Vertex<String> vertex7 = new Vertex<>("Atlanta, GA");
        Vertex<String> vertex8 = new Vertex<>("Orlando, FL");
        Vertex<String> vertex9 = new Vertex<>("Memphis, TN");
        Vertex<String> vertex10 = new Vertex<>("Grove City, OH");
        Vertex<String> vertex11 = new Vertex<>("Indianapolis, IN");
        Vertex<String> vertex12 = new Vertex<>("Detroit, MI");
        Vertex<String> vertex13 = new Vertex<>("New Berlin, WI");
        Vertex<String> vertex14 = new Vertex<>("Minneapolis, MN");
        Vertex<String> vertex15 = new Vertex<>("St. Louis, MO");
        Vertex<String> vertex16 = new Vertex<>("Kansas, KS");
        Vertex<String> vertex17 = new Vertex<>("Dallas, TX");
        Vertex<String> vertex18 = new Vertex<>("Houston, TX");
        Vertex<String> vertex19 = new Vertex<>("Denver, CO");
        Vertex<String> vertex20 = new Vertex<>("Salt Lake City, UT");
        Vertex<String> vertex21= new Vertex<>("Phoenix, AZ");
        Vertex<String> vertex22 = new Vertex<>("Los Angeles, CA");
        Vertex<String> vertex23 = new Vertex<>("Chino, CA");
        Vertex<String> vertex24 = new Vertex<>("Sacramento, CA");
        Vertex<String> vertex25 = new Vertex<>("Seattle, WA");

        //defining edges from vertices with parameters as (Source,Destination,Distance)
        Edge e=new Edge(vertex1,vertex2,1);
        Edge e1=new Edge(vertex1,vertex4,1);
        Edge e2=new Edge(vertex2,vertex1,1);
        Edge e3=new Edge(vertex2,vertex6,1);
        Edge e4=new Edge(vertex3,vertex4,1);
        Edge e5=new Edge(vertex3,vertex10,1);
        Edge e6=new Edge(vertex4,vertex1,1);
        Edge e7=new Edge(vertex4,vertex3,1);
        Edge e8=new Edge(vertex5,vertex6,1);
        Edge e9=new Edge(vertex5,vertex9,1);
        Edge e10=new Edge(vertex6,vertex5,1);
        Edge e11=new Edge(vertex6,vertex2,1);
        Edge e12=new Edge(vertex7,vertex9,1);
        Edge e13=new Edge(vertex7,vertex8,1);
        Edge e14=new Edge(vertex8,vertex7,1);
        Edge e15=new Edge(vertex8,vertex18,1);
        Edge e16=new Edge(vertex9,vertex7,1);
        Edge e17=new Edge(vertex9,vertex5,1);
        Edge e18=new Edge(vertex10,vertex12,1);
        Edge e19=new Edge(vertex10,vertex3,1);
        Edge e20=new Edge(vertex11,vertex17,1);
        Edge e21=new Edge(vertex11,vertex15,1);
        Edge e22=new Edge(vertex12,vertex10,1);
        Edge e23=new Edge(vertex12,vertex13,1);
        Edge e24=new Edge(vertex13,vertex12,1);
        Edge e25=new Edge(vertex13,vertex14,1);
        Edge e26=new Edge(vertex14,vertex13,1);
        Edge e27=new Edge(vertex14,vertex25,1);
        Edge e28=new Edge(vertex15,vertex11,1);
        Edge e29=new Edge(vertex15,vertex16,1);
        Edge e30=new Edge(vertex16,vertex15,1);
        Edge e31=new Edge(vertex16,vertex19,1);
        Edge e32=new Edge(vertex17,vertex18,1);
        Edge e33=new Edge(vertex17,vertex11,1);
        Edge e34=new Edge(vertex18,vertex17,1);
        Edge e35=new Edge(vertex18,vertex8,1);
        Edge e36=new Edge(vertex19,vertex16,1);
        Edge e37=new Edge(vertex19,vertex20,1);
        Edge e38=new Edge(vertex20,vertex19,1);
        Edge e39=new Edge(vertex20,vertex21,1);
        Edge e40=new Edge(vertex21,vertex20,1);
        Edge e41=new Edge(vertex21,vertex24,1);
        Edge e42=new Edge(vertex22,vertex24,1);
        Edge e43=new Edge(vertex22,vertex23,1);
        Edge e44=new Edge(vertex23,vertex22,1);
        Edge e45=new Edge(vertex23,vertex25,1);
        Edge e46=new Edge(vertex24,vertex21,1);
        Edge e47=new Edge(vertex24,vertex22,1);
        Edge e48=new Edge(vertex25,vertex23,1);
        Edge e49=new Edge(vertex25,vertex14,1);

        ArrayList<Edge> edges= new ArrayList<> ();

        //adding to the arraylist of edges
        edges.add(e);
        edges.add(e1);
        edges.add(e2);
        edges.add(e3);
        edges.add(e4);
        edges.add(e5);
        edges.add(e6);
        edges.add(e7);
        edges.add(e8);
        edges.add(e9);
        edges.add(e10);
        edges.add(e11);
        edges.add(e12);
        edges.add(e13);
        edges.add(e14);
        edges.add(e15);
        edges.add(e16);
        edges.add(e17);
        edges.add(e18);
        edges.add(e19);
        edges.add(e20);
        edges.add(e21);
        edges.add(e22);
        edges.add(e23);
        edges.add(e24);
        edges.add(e25);
        edges.add(e26);
        edges.add(e27);
        edges.add(e28);
        edges.add(e29);
        edges.add(e30);
        edges.add(e31);
        edges.add(e32);
        edges.add(e33);
        edges.add(e34);
        edges.add(e35);
        edges.add(e36);
        edges.add(e37);
        edges.add(e38);
        edges.add(e39);
        edges.add(e40);
        edges.add(e41);
        edges.add(e42);
        edges.add(e43);
        edges.add(e44);
        edges.add(e45);
        edges.add(e46);
        edges.add(e47);
        edges.add(e48);
        edges.add(e49);

        return edges;

    }

    //finding the shortest path, returning a linked list of all nodes traversed
    public LinkedList<Vertex> linkPath() {
        LinkedList<Vertex> path=null;

        // Finding length of path (number of steps) between nodes:
        try {
            //int pathLength = new DijkstraAlgorithm(new Graph(edges)).execute(vertexFrom).getShortestPathLength(vertexFrom, vertexTo);
            Log.d("demo",vertexSource.toString());
            path = new DijkstraAlgorithm(new Graph(funcDefine())).execute(vertexSource).getPath(vertexDest);
            Log.d("Path", "Path linked list is " + path.toString());


        } catch (PathNotFoundException e1) {
            e1.printStackTrace();
        }
        return path;
    }

    //total of shortest distance after traversing through all nodes
    public int linkWeight()
    {
        int pathWeightedDistance=0;
        //DijkstraAlgorithm dj= new DijkstraAlgorithm();
        // Finding weighted distance between nodes.
        try {
            pathWeightedDistance = new DijkstraAlgorithm(new Graph(funcDefine())).execute(vertexSource).getDistance(vertexDest);
            Log.d("pathWeightedDistance", "pathWeightedDistance:"+pathWeightedDistance);
        } catch (PathNotFoundException e1) {
            e1.printStackTrace();
        }
        return pathWeightedDistance;

    }

}
