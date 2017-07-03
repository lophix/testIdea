import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import util.MyHttpRequest;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author xuj
 * @since 2017-07-03-9:59
 */
public class CyclotronPostLaunchPad {

    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors.newSingleThreadScheduledExecutor();

    static {
        disableSslVerification();
    }

    private static void disableSslVerification() {
        try
        {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = (hostname, session) -> true;

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("http://192.168.10.5:8443/timesharing");
        request.addHeader("content-type", "application/x-www-form-urlencoded");
        request.addHeader("cache-control", "no-cache");

        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("app_id", "201704282300007148"));
        nvps.add(new BasicNameValuePair("method", "pt104"));
        nvps.add(new BasicNameValuePair("charset", "utf-8"));
        nvps.add(new BasicNameValuePair("version", "2017-07-03 03:07:50"));
        nvps.add(new BasicNameValuePair("biz_content", "{\"carPlate\":\"粤B00000\",\"device_id\":\"3184025\",\"order_id\":\"ea93864e-0cf8-42ff-bf00-35bbb12d03cc\",\"order_auth\":\"admin\",\"order_live\":\"20170526162900\",\"opt\":3,\"notify_url\":\"https://www.local.com/car/notify.jsp\"}"));
        nvps.add(new BasicNameValuePair("sign", "ff8c067c71d7b620dbe832917ffc6f80"));
        request.setEntity(new UrlEncodedFormEntity(nvps));

        SCHEDULED_EXECUTOR_SERVICE.schedule(() -> httpClient.execute(request),
                10,
                TimeUnit.SECONDS);
    }
}
