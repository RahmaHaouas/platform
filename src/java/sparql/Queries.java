package sparql;

import java.io.IOException;
import java.util.ArrayList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.filechooser.FileSystemView;
import org.apache.jena.graph.NodeFactory;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFactory;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;
import org.apache.jena.sparql.core.DatasetGraph;
import org.apache.jena.sparql.core.DatasetGraphFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.apache.jena.util.FileManager;

public class Queries {
    

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list = informatique();
        for (int i =0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.size());
    }
    
    public static ArrayList<String> getSol(String Panne){
        FileSystemView view = FileSystemView.getFileSystemView();
        String Path_to_Desktop = view.getHomeDirectory().toString();
        String rdfFile = Path_to_Desktop+"/Leoni/ontology/panneOnto.owl";
        Model model = ModelFactory.createMemModelMaker().createModel(null);
    	model.read(rdfFile,null);

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                        "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"+
        		"PREFIX panne:<http://www.semanticweb.org/rahma/ontologies/2020/pannesOnto.owl#>"
        		+"SELECT ?Comment ?Date WHERE {?Panne panne:hasSol ?Solution.?Panne rdfs:comment '"+Panne+"'^^xsd:string. ?Solution rdfs:comment ?Comment . ?Solution panne:DateSol ?Date .}" ;

                
        
        Query querySelect = QueryFactory.create(queryString);
        
        QueryExecution qexec = QueryExecutionFactory.create(querySelect, model);
        ResultSet results = qexec.execSelect();
        ArrayList<String> row = new ArrayList<>();
        try {
            while ( results.hasNext() ) {
                QuerySolution sol = results.next();
                String name = sol.get("Comment").toString();
                String date = sol.get("Date").toString();
                row.add(name+"["+date+"]");
            }
            return row;
        } finally {
            return row;
        }

    }
    
    public static ArrayList<String> checkLogin(String login, String mdp){
        FileSystemView view = FileSystemView.getFileSystemView();
        String Path_to_Desktop = view.getHomeDirectory().toString();
        String rdfFile = Path_to_Desktop+"/Leoni/ontology/panneOnto.owl";
        Model model = ModelFactory.createMemModelMaker().createModel(null);
    	model.read(rdfFile,null);

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                        "PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
                        "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"+
        		"PREFIX panne:<http://www.semanticweb.org/rahma/ontologies/2020/pannesOnto.owl#>"
        		+"SELECT ?Employee ?Name ?Surname ?Login ?Email WHERE {?Employee rdf:type panne:employee. ?Employee panne:Login '"+login+"'^^xsd:string. ?Employee panne:Password '"+mdp+"'^^xsd:string. ?Employee panne:Surname ?Surname. ?Employee panne:Name ?Name. ?Employee panne:Login ?Login. ?Employee panne:Email ?Email}" ;

                
        
        Query querySelect = QueryFactory.create(queryString);
        
        QueryExecution qexec = QueryExecutionFactory.create(querySelect, model);
        ResultSet results = qexec.execSelect();
        ArrayList<String> row = new ArrayList<>();
        try {
            while ( results.hasNext() ) {
                QuerySolution sol = results.next();
                String name = sol.get("Name").toString();
                String surname = sol.get("Surname").toString();
                String Username = sol.get("Login").toString();
                String email = sol.get("Email").toString();
                row.add(name);
                row.add(surname);
                row.add(Username);
                row.add(email);
            }
            return row;
        } catch(Exception e) {
            
            return row;
        }

    }
    
    public static ArrayList<String> getRecentPannes(){
        FileSystemView view = FileSystemView.getFileSystemView();
        String Path_to_Desktop = view.getHomeDirectory().toString();
        String rdfFile = Path_to_Desktop+"/Leoni/ontology/panneOnto.owl";
        Model model = ModelFactory.createMemModelMaker().createModel(null);
    	model.read(rdfFile,null);

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        		"PREFIX panne:<http://www.semanticweb.org/rahma/ontologies/2020/pannesOnto.owl#>"
        		+"SELECT ?Comment WHERE {?Pann rdf:type ?Panne. ?Panne rdfs:subClassOf* panne:Panne. ?Pann  rdfs:comment ?Comment} LIMIT 5" ;

                
        
        Query querySelect = QueryFactory.create(queryString);
        
        QueryExecution qexec = QueryExecutionFactory.create(querySelect, model);
        ResultSet results = qexec.execSelect();
        ArrayList<String> row = new ArrayList<>();
        try {
            while ( results.hasNext() ) {
                QuerySolution sol = results.next();
                String name = sol.get("Comment").toString();
                row.add(name);
            }
            return row;
        } finally {
            return row;
        }

    }
    
    public static ArrayList<String> chercherPannes(String cmnt){
        FileSystemView view = FileSystemView.getFileSystemView();
        String Path_to_Desktop = view.getHomeDirectory().toString();
        String rdfFile = Path_to_Desktop+"/Leoni/ontology/panneOnto.owl";
        Model model = ModelFactory.createMemModelMaker().createModel(null);
    	model.read(rdfFile,null);

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        		"PREFIX panne:<http://www.semanticweb.org/rahma/ontologies/2020/pannesOnto.owl#>"
        		+"SELECT ?Date ?Comment WHERE {?Pann rdf:type ?Panne. ?Panne rdfs:subClassOf* panne:Panne. ?Pann rdfs:comment ?Comment. ?Pann panne:DatePanne ?Date . filter contains(?Comment,'"+cmnt+"')}" ;

                
        
        Query querySelect = QueryFactory.create(queryString);
        
        QueryExecution qexec = QueryExecutionFactory.create(querySelect, model);
        ResultSet results = qexec.execSelect();
        ArrayList<String> row = new ArrayList<>();
        try {
            while ( results.hasNext() ) {
                QuerySolution sol = results.next();
                String name = sol.get("Comment").toString();
                String date = sol.get("Date").toString();
                row.add(name+"["+date+"]");
            }
            return row;
        } finally {
            return row;
        }

    }   
    
    public static ArrayList<String> getAllPannes(){
        FileSystemView view = FileSystemView.getFileSystemView();
        String Path_to_Desktop = view.getHomeDirectory().toString();
        String rdfFile = Path_to_Desktop+"/Leoni/ontology/panneOnto.owl";
        Model model = ModelFactory.createMemModelMaker().createModel(null);
    	model.read(rdfFile,null);

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        		"PREFIX panne:<http://www.semanticweb.org/rahma/ontologies/2020/pannesOnto.owl#>"
        		+"SELECT ?Comment ?Date WHERE {?Pann rdf:type ?Panne. ?Panne rdfs:subClassOf* panne:Panne. ?Pann  rdfs:comment ?Comment. ?Pann panne:DatePanne ?Date .}" ;

                
        
        Query querySelect = QueryFactory.create(queryString);
        
        QueryExecution qexec = QueryExecutionFactory.create(querySelect, model);
        ResultSet results = qexec.execSelect();
        ArrayList<String> row = new ArrayList<>();
        try {
            while ( results.hasNext() ) {
                QuerySolution sol = results.next();
                String name = sol.get("Comment").toString();
                String date = sol.get("Date").toString();
                row.add(name+"["+date+"]");
            }
            return row;
        } finally {
            return row;
        }

    } 
    
    public static ArrayList<String> getGeneralPannes(){
        FileSystemView view = FileSystemView.getFileSystemView();
        String Path_to_Desktop = view.getHomeDirectory().toString();
        String rdfFile = Path_to_Desktop+"/Leoni/ontology/panneOnto.owl";
        Model model = ModelFactory.createMemModelMaker().createModel(null);
    	model.read(rdfFile,null);

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                        "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                        +"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        		"PREFIX panne:<http://www.semanticweb.org/rahma/ontologies/2020/pannesOnto.owl#>"
        		+"SELECT ?Comment ?Date WHERE {?Panne rdf:type panne:PanneProduction.?Panne rdfs:comment  ?Comment .  ?Panne panne:DatePanne ?Date .} LIMIT 5" ;

                
        
        Query querySelect = QueryFactory.create(queryString);
        
        QueryExecution qexec = QueryExecutionFactory.create(querySelect, model);
        ResultSet results = qexec.execSelect();
        ArrayList<String> row = new ArrayList<>();
        try {
            while ( results.hasNext() ) {
                QuerySolution sol = results.next();
                String name = sol.get("Comment").toString();
                String date = sol.get("Date").toString();
                row.add(name+"["+date+"]");
            }
            return row;
        } finally {
            return row;
        }

    }  
    
    public static ArrayList<String> getInformatiquePannes(){
        FileSystemView view = FileSystemView.getFileSystemView();
        String Path_to_Desktop = view.getHomeDirectory().toString();
        String rdfFile = Path_to_Desktop+"/Leoni/ontology/panneOnto.owl";
        Model model = ModelFactory.createMemModelMaker().createModel(null);
    	model.read(rdfFile,null);

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                        "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                        +"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        		"PREFIX panne:<http://www.semanticweb.org/rahma/ontologies/2020/pannesOnto.owl#>"
        		+"SELECT ?Comment ?Date WHERE {?Panne rdf:type panne:PanneInformatique.?Panne rdfs:comment  ?Comment .  ?Panne panne:DatePanne ?Date .} LIMIT 5" ;

                
        
        Query querySelect = QueryFactory.create(queryString);
        
        QueryExecution qexec = QueryExecutionFactory.create(querySelect, model);
        ResultSet results = qexec.execSelect();
        ArrayList<String> row = new ArrayList<>();
        try {
            while ( results.hasNext() ) {
                QuerySolution sol = results.next();
                String name = sol.get("Comment").toString();
                String date = sol.get("Date").toString();
                row.add(name+"["+date+"]");
            }
            return row;
        } finally {
            return row;
        }

    } 
        
    public static ArrayList<String> getElectriquePannes(){
        FileSystemView view = FileSystemView.getFileSystemView();
        String Path_to_Desktop = view.getHomeDirectory().toString();
        String rdfFile = Path_to_Desktop+"/Leoni/ontology/panneOnto.owl";
        Model model = ModelFactory.createMemModelMaker().createModel(null);
    	model.read(rdfFile,null);

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                        "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                        +"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        		"PREFIX panne:<http://www.semanticweb.org/rahma/ontologies/2020/pannesOnto.owl#>"
        		+"SELECT ?Comment ?Date WHERE {?Panne rdf:type panne:PanneElectrique.?Panne rdfs:comment  ?Comment .  ?Panne panne:DatePanne ?Date .} LIMIT 5" ;

                
        
        Query querySelect = QueryFactory.create(queryString);
        
        QueryExecution qexec = QueryExecutionFactory.create(querySelect, model);
        ResultSet results = qexec.execSelect();
        ArrayList<String> row = new ArrayList<>();
        try {
            while ( results.hasNext() ) {
                QuerySolution sol = results.next();
                String name = sol.get("Comment").toString();
                String date = sol.get("Date").toString();
                row.add(name+"["+date+"]");
            }
            return row;
        } finally {
            return row;
        }

    } 
    
    public static ArrayList<String> getMecaniquePannes(){
        FileSystemView view = FileSystemView.getFileSystemView();
        String Path_to_Desktop = view.getHomeDirectory().toString();
        String rdfFile = Path_to_Desktop+"/Leoni/ontology/panneOnto.owl";
        Model model = ModelFactory.createMemModelMaker().createModel(null);
    	model.read(rdfFile,null);

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                        "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                        +"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        		"PREFIX panne:<http://www.semanticweb.org/rahma/ontologies/2020/pannesOnto.owl#>"
        		+"SELECT ?Comment ?Date WHERE {?Panne rdf:type panne:PanneMecanique.?Panne rdfs:comment  ?Comment .  ?Panne panne:DatePanne ?Date .} LIMIT 5" ;

                
        
        Query querySelect = QueryFactory.create(queryString);
        
        QueryExecution qexec = QueryExecutionFactory.create(querySelect, model);
        ResultSet results = qexec.execSelect();
        ArrayList<String> row = new ArrayList<>();
        try {
            while ( results.hasNext() ) {
                QuerySolution sol = results.next();
                String name = sol.get("Comment").toString();
                String date = sol.get("Date").toString();
                row.add(name+"["+date+"]");
            }
            return row;
        } finally {
            return row;
        }

    } 
    
    public static ArrayList<String> mecanique(){
        FileSystemView view = FileSystemView.getFileSystemView();
        String Path_to_Desktop = view.getHomeDirectory().toString();
        String rdfFile = Path_to_Desktop+"/Leoni/ontology/panneOnto.owl";
        Model model = ModelFactory.createMemModelMaker().createModel(null);
    	model.read(rdfFile,null);

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                        "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                        +"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        		"PREFIX panne:<http://www.semanticweb.org/rahma/ontologies/2020/pannesOnto.owl#>"
        		+"SELECT ?Comment ?Date WHERE {?Panne rdf:type panne:PanneMecanique.?Panne rdfs:comment  ?Comment .  ?Panne panne:DatePanne ?Date .}" ;

                
        
        Query querySelect = QueryFactory.create(queryString);
        
        QueryExecution qexec = QueryExecutionFactory.create(querySelect, model);
        ResultSet results = qexec.execSelect();
        ArrayList<String> row = new ArrayList<>();
        try {
            while ( results.hasNext() ) {
                QuerySolution sol = results.next();
                String name = sol.get("Comment").toString();
                String date = sol.get("Date").toString();
                row.add(name+"["+date+"]");
            }
            return row;
        } finally {
            return row;
        }

    } 
    
    public static ArrayList<String> electrique(){
        FileSystemView view = FileSystemView.getFileSystemView();
        String Path_to_Desktop = view.getHomeDirectory().toString();
        String rdfFile = Path_to_Desktop+"/Leoni/ontology/panneOnto.owl";
        Model model = ModelFactory.createMemModelMaker().createModel(null);
    	model.read(rdfFile,null);

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                        "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                        +"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        		"PREFIX panne:<http://www.semanticweb.org/rahma/ontologies/2020/pannesOnto.owl#>"
        		+"SELECT ?Comment ?Date WHERE {?Panne rdf:type panne:PanneElectrique.?Panne rdfs:comment  ?Comment .  ?Panne panne:DatePanne ?Date .}" ;

                
        
        Query querySelect = QueryFactory.create(queryString);
        
        QueryExecution qexec = QueryExecutionFactory.create(querySelect, model);
        ResultSet results = qexec.execSelect();
        ArrayList<String> row = new ArrayList<>();
        try {
            while ( results.hasNext() ) {
                QuerySolution sol = results.next();
                String name = sol.get("Comment").toString();
                String date = sol.get("Date").toString();
                row.add(name+"["+date+"]");
            }
            return row;
        } finally {
            return row;
        }

    } 
    
    public static ArrayList<String> informatique(){
        FileSystemView view = FileSystemView.getFileSystemView();
        String Path_to_Desktop = view.getHomeDirectory().toString();
        String rdfFile = Path_to_Desktop+"/Leoni/ontology/panneOnto.owl";
        Model model = ModelFactory.createMemModelMaker().createModel(null);
    	model.read(rdfFile,null);

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                        "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                        +"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        		"PREFIX panne:<http://www.semanticweb.org/rahma/ontologies/2020/pannesOnto.owl#>"
        		+"SELECT ?Comment ?Date WHERE {?Panne rdf:type panne:PanneInformatique.?Panne rdfs:comment  ?Comment .  ?Panne panne:DatePanne ?Date .}" ;

                
        
        Query querySelect = QueryFactory.create(queryString);
        
        QueryExecution qexec = QueryExecutionFactory.create(querySelect, model);
        ResultSet results = qexec.execSelect();
        ArrayList<String> row = new ArrayList<>();
        try {
            while ( results.hasNext() ) {
                QuerySolution sol = results.next();
                String name = sol.get("Comment").toString();
                String date = sol.get("Date").toString();
                row.add(name+"["+date+"]");
            }
            return row;
        } finally {
            return row;
        }

    } 
    
    public static ArrayList<String> production(){
        FileSystemView view = FileSystemView.getFileSystemView();
        String Path_to_Desktop = view.getHomeDirectory().toString();
        String rdfFile = Path_to_Desktop+"/Leoni/ontology/panneOnto.owl";
        Model model = ModelFactory.createMemModelMaker().createModel(null);
    	model.read(rdfFile,null);

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                        "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                        +"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
        		"PREFIX panne:<http://www.semanticweb.org/rahma/ontologies/2020/pannesOnto.owl#>"
        		+"SELECT ?Comment ?Date WHERE {?Panne rdf:type panne:PanneProduction.?Panne rdfs:comment  ?Comment .  ?Panne panne:DatePanne ?Date .}" ;

                
        
        Query querySelect = QueryFactory.create(queryString);
        
        QueryExecution qexec = QueryExecutionFactory.create(querySelect, model);
        ResultSet results = qexec.execSelect();
        ArrayList<String> row = new ArrayList<>();
        try {
            while ( results.hasNext() ) {
                QuerySolution sol = results.next();
                String name = sol.get("Comment").toString();
                String date = sol.get("Date").toString();
                row.add(name+"["+date+"]");
            }
            return row;
        } finally {
            return row;
        }

    } 
}
