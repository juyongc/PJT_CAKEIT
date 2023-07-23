package cakeit.server.cakeStore.service;

import cakeit.server.cakeStore.dto.GetCakeStoreListRequestDto;
import cakeit.server.cakeStore.dto.GetCakeStoreListResponseDto;
import cakeit.server.cakeStore.repository.CakeStoreRepository;
import com.squareup.okhttp.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CakeStoreServiceImpl implements CakeStoreService {

    private final CakeStoreRepository cakeStoreRepository;
    private static final String YOUR_API_KEY = "-";

    @Override
    public List<GetCakeStoreListResponseDto> getCakeStoreListByLatitudeAndLongitude(GetCakeStoreListRequestDto getCakeStoreListRequestDto) throws IOException {

        Double longitude = getCakeStoreListRequestDto.getLongitude();
        Double latitude = getCakeStoreListRequestDto.getLatitude();

        getnearbyCakeStoreListFromGoogleAPI();

        return null;
    }

//    public static List<GetCakeStoreListResponseDto> getnearbyCakeStoreListFromGoogleAPI() throws IOException {
    public static void getnearbyCakeStoreListFromGoogleAPI() throws IOException {

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://maps.googleapis.com/maps/api/place/nearbysearch/json?keyword=수제 케이크&location=37.4992131%2C127.0280048&radius=5000&key=" + YOUR_API_KEY)
                .build();

        log.info("execute!!!=============================================================");
        Response response = client.newCall(request).execute();
        log.info(response.toString());

        //Response형 -> String형
        String userString = response.body().string();

        // String형 ->json형
//        JSONObject userJson = new JSONObject(userString);

    }

}
