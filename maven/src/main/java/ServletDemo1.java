import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String encoding=req.getCharacterEncoding();
        String contentType=req.getContentType();
        String contextPath=req.getContextPath();
        String ua=req.getHeader("User-Agent");
        String host=req.getHeader("HOST");
        String method=req.getMethod();
        String queryString=req.getQueryString();
        String url=req.getRequestURI();
        int contentLength=req.getContentLength();
        Writer writer=resp.getWriter();
        writer.write("<html>");
        writer.write("<br/>");
        writer.write("encoding->"+encoding);
        writer.write("<br/>");
        writer.write("contentType->"+contentType);
        writer.write("<br/>");
        writer.write("contextPath->"+contextPath);
        writer.write("<br/>");
        writer.write("User-Agent->"+ua);
        writer.write("<br/>");
        writer.write("HOST->"+host);
        writer.write("<br/>");
        writer.write("method->"+method);
        writer.write("<br/>");
        writer.write("queryString->"+queryString);
        writer.write("<br/>");
        writer.write("url->"+url);
        writer.write("<br/>");
        writer.write("contentLength"+contentLength);
        writer.write("<br/>");
        writer.write("</html>");
    }
}
