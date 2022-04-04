import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/counter")
public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(Counter.value());
        resp.setStatus(HttpStatus.OK_200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Counter.increment();
        resp.setStatus(HttpStatus.OK_200);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var header = req.getHeader("Subtraction-Value");
        if(header != null)
        {
            Counter.decreaseValue(Integer.parseInt(header));
            resp.setStatus(HttpStatus.OK_200);
        } else {
            resp.setStatus(HttpStatus.NOT_MODIFIED_304);
        }
    }
}
