import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class Student extends HttpServlet {

    // Method to handle GET method request.
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Student Data";
        String docType = "<!doctype html>\n";
        String value = request.getParameter("RegValue");
        String resultname = "";
        Integer resultrank = 0;
        // String value = request.getParameter("register");

        Student1[] arr;
        // Allocating memory for 2 objects
        // of type student
        arr = new Student1[5];
        // Initializing the first element
        // of the array
        arr[0] = new Student1(4010, "Naruto", 2);
        // Initializing the second element
        // of the array
        arr[1] = new Student1(4011, "Luffy", 5);
        arr[2] = new Student1(4012, "Sasuke", 1);
        arr[3] = new Student1(4013, "Zoro", 4);
        arr[4] = new Student1(4014, "Dragon", 3);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].id == Integer.parseInt(value)) {
                resultname = arr[i].name;
                resultrank = arr[i].rank;
                break;
            }

        }

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n"
                + "<style>table, td, th { border: 1px solid blue;} table {border-collapse: collapse;width: 100%;} td { text-align: center;}</style>\n"
                +
                "<body bgcolor = \"#00FFFF\">\n" +
                "<center><h1 align = \"center\">" + title + "</h1>\n" +
                "<table>" +
                "<thead><th>Student Reg No</th><th>Student Name</th><th>Student Rank</th></thead>\n" +
                "<tbody><tr><td>" + value + "</td><td>" + resultname + " </td><td>" + resultrank
                + " </td> </tr></tbody>" +
                "</table>" + "</body>" +
                "</html>");
    }

    // Method to handle POST method request.
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    class Student1 {

        public int id;
        public String name;
        public int rank;

        // Student class constructor
        Student1(int id, String name, int rank) {
            this.id = id;
            this.name = name;
            this.rank = rank;
        }

    }
}