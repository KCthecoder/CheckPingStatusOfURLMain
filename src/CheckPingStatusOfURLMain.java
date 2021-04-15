import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author java2blog.com
 *
 */

public class CheckPingStatusOfURLMain {
    public static void main(String args[]) throws Exception {

        String status1 = getStatus("https://ba71cc06-65b2-4699-ae4a-9080140baea4.mock.pstmn.io/notfoundstaues");
        System.out.println("Java2blog.com is : " + status1);

        String status2 = getStatus("https://ba71cc06-65b2-4699-ae4a-9080140baea4.mock.pstmn.io/failedstatus");
        System.out.println("javablog2.com is : " + status2);

    }

    public static String getStatus(String url) throws IOException {

        String result = "";
        int code = 0;

        try {
            URL urlObj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
            con.setRequestMethod("GET");
            // Set connection timeout
            con.setConnectTimeout(3000);
            con.connect();

            code = con.getResponseCode();
            switch (code)
            {
                case 200: result="API Functioning"; break;
                case 400: result="Bad Request"; break;
                case 401: result="Authentication Failure"; break;
                case 403: result="Forbidden"; break;
                case 404: result="API not found"; break;
                case 405: result="Method Not Allowed"; break;
                case 409: result="Conflict"; break;
                case 412: result="Precondition Failed"; break;
                case 413: result="Request Entity Too Large"; break;
                case 500: result="Internal Server Error"; break;
                case 501: result="Not Implemented"; break;
                case 503: result="Service Un Available"; break;

            }
        } catch (Exception e) {
            result = "Invalid API link";
        }
        return result;
    }

}
