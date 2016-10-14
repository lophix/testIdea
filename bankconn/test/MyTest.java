import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 杉杉接口开放平台测试
 *
 * @Authuor Administrator
 * @Create 2016-09-13-10:59
 */
public class MyTest {
    /**
     * @param args
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static void main(String[] args) throws IOException {


        HttpClient httpClient = new DefaultHttpClient();

        //这段代码为获取token的代码，获取的结果能得到token，需要从里面取出token的值
        HttpPost method = new HttpPost("http://183.131.244.187:7111/token");

        ArrayList<NameValuePair> list = new ArrayList<>();

        list.add(new BasicNameValuePair("grant_type","password"));  //固定写法
        list.add(new BasicNameValuePair("username","Public"));  //此为测试账号，以后需要改为NC分配的接口账号
        list.add(new BasicNameValuePair("password","123@SSOpenAPI"));  //此为测试账号的密码，以后需要改为NC分配的接口密码

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list);
        method.setEntity(entity);

        //客户端号，固定写法
        method.addHeader("Authorization","Basic d2VicG9ydGFsOndlYnBvcnRhbEBTU09wZW5BUEk=");

        HttpResponse response = httpClient.execute(method);

        HttpEntity resEntity = response.getEntity();
        String tokenResult = null;
        if(resEntity != null) {
            tokenResult = EntityUtils.toString(resEntity);

            System.out.println(tokenResult);
        }

        JSONObject tokenJson = JSONObject.fromObject(tokenResult);
        String accessToken = (String) tokenJson.get("access_token");

        //Post到具体的接口，此地址为测试环境
        HttpPost postApi = new HttpPost("http://183.131.244.187:7111/api/Core/CallMethod");

        //添加httpheader，Authorization为固定值，Bearer 后面的值为上面的代码取出的token
        postApi.addHeader("Authorization", "Bearer " + accessToken);

        //API详细调用的请求参数，Method为固定写法，后面的方法为具体的API方法。
        //filter为查询参数
        String postApiValue="{\"Method\":\"SSOpenApi.BasicHandler.MaterialHandler.Find\",\"filter\":{\"Skip\":0,\"Take\":100}}";

        StringEntity callApiEntity = new StringEntity (postApiValue,"utf-8");
        callApiEntity.setContentEncoding("UTF-8");
        callApiEntity.setContentType("application/json");
        postApi.setEntity(callApiEntity);

        HttpResponse apiresponse = httpClient.execute(postApi);

        HttpEntity apiresEntity = apiresponse.getEntity();
        if(apiresEntity != null){
            String apiResult = EntityUtils.toString(apiresEntity);
            System.out.println(apiResult);
        }
    }

}
