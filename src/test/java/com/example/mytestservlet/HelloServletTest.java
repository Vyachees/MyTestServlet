package com.example.mytestservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;


class HelloServletTest extends Mockito {

/*
// given
MockHttpServletRequest request = new MockHttpServletRequest();
request.setServerName("www.example.com");
request.setRequestURI("/foo");
request.setQueryString("param1=value1&param");

// when
String url = request.getRequestURL() + '?' + request.getQueryString(); // assuming there is always queryString.

// then
assertThat(url, is("http://www.example.com:80/foo?param1=value1&param"));
 */

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        request.setAttribute("serverName","www.example.com");

       // when(request.getParameter("username")).thenReturn("me");
      //  when(request.getParameter("password")).thenReturn("secret");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
      //  System.out.println(request.getMethod());
       // new MyServlet().doPost(request, response);



       // verify(request, atLeast(1)).getParameter("username"); // only if you want to verify username was called...
      //  writer.flush(); // it may not have been flushed yet...
       // assertTrue(stringWriter.toString().contains("My expected string"));
    }
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    MyServlet myServlet;

    @BeforeEach
    void setUp() {

    }
/*
    private String firstName;
    private String lastName;
    private String birthDay;
    private String company;
 */
    @Test
    void doPost() throws IOException {

        // create `ObjectMapper` instance
        ObjectMapper mapper = new ObjectMapper();
        // create a JSON object
        ObjectNode user = mapper.createObjectNode();
        user.put("firstName", "John");
        user.put("lastName", "Snow");
        user.put("birthDay", "2000-01-05");
        user.put("company", "Nickelodeon");
        System.out.println(user);
        System.out.println(request.getRequestURI()+response+myServlet+"");

        // convert `ObjectNode` to pretty-print JSON
        // without pretty-print, use `user.toString()` method
       // String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);


       // System.out.println(myServlet.getServletName());




    }

    @Test
    void doGet() {
    }

    @Test
    void doPut() {
    }

    @Test
    void doDelete() {
    }
}
