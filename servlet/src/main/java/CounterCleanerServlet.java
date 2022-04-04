import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/counter/clear")
public class CounterCleanerServlet extends HttpServlet {
    private String authCookie = "hh-auth";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            var cookies = req.getCookies();
            if(cookies == null){
                resp.setStatus(HttpStatus.OK_200);
                return;
            }
            for (javax.servlet.http.Cookie cookie : cookies) {
                if(cookie.getName().equals(authCookie) && cookie.getValue().length() > 10) {
                    resp.setStatus(HttpStatus.RESET_CONTENT_205);
                    Counter.reset();
                    return;
                }
            }
            resp.setStatus(HttpStatus.OK_200);
        }
}
