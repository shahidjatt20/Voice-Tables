package com.Teconz.voicetables.Ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.Teconz.voicetables.R;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;


public class AdmobHelper extends Activity {
    static AdView adView;
    static InterstitialAd interstitialAd1;
    static AdRequest adRequest;
    @SuppressLint("StaticFieldLeak")
    static AdLoader adLoader;
    @SuppressLint("StaticFieldLeak")
    static NativeAdView nativeAdView;
    @SuppressLint("StaticFieldLeak")
    static FrameLayout nativeContainer;
    static NativeAd nativeAd1;
    static boolean connected = false;
    static String TAG = "admob_ad";
    @SuppressLint("StaticFieldLeak")
    static FrameLayout bannerLayout;

    public static void iniSDk(Activity activity) {

        MobileAds.initialize(activity, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(
                    @NonNull InitializationStatus initializationStatus) {
                Log.e(TAG, "admob sdk initialized success");
            }
        });
        //AudienceNetworkAds.initialize(activity);
         // AdmobHelper.loadAdmobNativeAd(activity);
         AdmobHelper.loadAdmobInterstitialAd(activity);
    }

    //.. adaptive banner
    public static void loadAdaptiveBannerAd(Activity activity) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adView = new AdView(activity);
                adView.setAdUnitId(activity.getString(R.string.admob_banner_id));
                bannerLayout = activity.findViewById(R.id.adView);
                bannerLayout.addView(adView);
                AdRequest adRequest = new AdRequest.Builder().build();
                adView.setAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.e(TAG, "banner ad: loading failed " + loadAdError.getMessage());
                        Log.e(TAG, "banner ad: loading failed " + loadAdError.toString());
                        Log.e(TAG, "banner ad: loading failed " + loadAdError.getDomain());
                        Log.e(TAG, "banner ad: loading failed " + loadAdError.getResponseInfo());
                        Log.e(TAG, "banner ad: loading failed " + loadAdError.getCause());

                    }

                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                        Log.e(TAG, "banner ad: laoded success");
                    }
                });
                AdSize adSize = getAdSize(activity);
                adView.setAdSize(adSize);
                adView.loadAd(adRequest);
            }
        }, 1000);
    }

    private static AdSize getAdSize(Activity activity) {
        // Step 2 - Determine the screen width (less decorations)
        // to use for the ad width.
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        // Step 3 - Get adaptive ad size and return for setting on the ad view.
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize
                (activity, adWidth);
    }




    // Native Ad
    private static void populateNativeAdView(NativeAd nativeAd,
                                             NativeAdView adView) {
        // Set the media view. Media content will be automatically populated in the media view once
        // adView.setNativeAd() is called.
        MediaView mediaView = adView.findViewById(R.id.ad_media);
        adView.setMediaView(mediaView);

        // Set other ad assets.
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

        // The headline is guaranteed to be in every NativeAd.
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());

        // These assets aren't guaranteed to be in every NativeAd, so it's important to
        // check before trying to display them.
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(
                    nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null || nativeAd.getStarRating() < 3) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }

        adView.setNativeAd(nativeAd);
    }

    //... load native ad
    public static void loadAdmobNativeAd(Activity activity) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adLoader = new AdLoader.Builder(activity,
                        activity.getString(R.string.admob_native_id))
                        .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                            @Override
                            public void onNativeAdLoaded(@NonNull NativeAd
                                                                 nativeAd) {
                                nativeAd1 = nativeAd;
                                Log.e(TAG, "native ad: laoded success");
                            }
                        })
                        .withAdListener(new AdListener() {
                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError
                                                                 loadAdError) {
                                Log.e(TAG, "native ad : loading failed " +
                                        "" + loadAdError.toString());
                                Log.e(TAG, "native ad: loading failed " + loadAdError.toString());
                                Log.e(TAG, "native ad: loading failed " + loadAdError.getDomain());
                                Log.e(TAG, "native ad: loading failed " + loadAdError.getResponseInfo());
                                Log.e(TAG, "native ad: loading failed " + loadAdError.getCause());

                            }
                        }).build();
                adLoader.loadAd(new AdRequest.Builder().build());
            }
        }, 1000);
    }

    //..... load native ad after internet connected
    private static void loadNativeAdAfterInternetConnected(
            Activity activity, View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                adLoader = new AdLoader.Builder(activity, activity.getString(R.string.admob_native_id))
                        .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                            @Override
                            public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {

                                nativeAd1 = nativeAd;
                                Log.e(TAG, "native ad: loaded success");

                                nativeContainer = view.findViewById(R.id.native_container);
                                nativeAdView = (NativeAdView) activity.getLayoutInflater()
                                        .inflate(R.layout.mediation_native_ad, null);

                                populateNativeAdView(nativeAd1, nativeAdView);
                                nativeContainer.removeAllViews();
                                nativeContainer.addView(nativeAdView);
                            }
                        })
                        .withAdListener(new AdListener() {
                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                Log.e(TAG, "native ad: loading failed   " + loadAdError.toString());
                                Log.e(TAG, "native ad: loading failed " + loadAdError.toString());
                                Log.e(TAG, "native ad: loading failed " + loadAdError.getDomain());
                                Log.e(TAG, "native ad: loading failed " + loadAdError.getResponseInfo());
                                Log.e(TAG, "native ad: loading failed " + loadAdError.getCause());
                                nativeAd1 = null;
                            }
                        }).build();
                adLoader.loadAd(new AdRequest.Builder().build());
            }
        }, 1000);
    }


    //... show native ad
    public static void show_AdmobNativeAd(Activity activity,
                                          View view) {
        if (nativeAd1 != null){
            nativeContainer = view.findViewById(R.id.native_container);
            nativeAdView = (NativeAdView) activity.getLayoutInflater()
                    .inflate(R.layout.mediation_native_ad, null);

            populateNativeAdView(nativeAd1, nativeAdView);
            nativeContainer.removeAllViews();
            nativeContainer.addView(nativeAdView);
            Log.e(TAG,"native ad: already loaded ,ad shown successfully "
                    +activity.getLocalClassName());
        }
        else  {
            loadNativeAdAfterInternetConnected(activity, view);
            Log.e(TAG, "native ad: connected to internet, loading native..., "
                    +activity.getLocalClassName());
        }

    }



    //... load interstitial ad
    public static void loadAdmobInterstitialAd(Activity activity){

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    adRequest = new AdRequest.Builder().build();
                    InterstitialAd.load(activity,activity.getString(R.string.admob_interstitial_id),
                            adRequest, new InterstitialAdLoadCallback() {
                                @Override
                                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                    // The mInterstitialAd reference will be null until
                                    // an ad is loaded.
                                    interstitialAd1 = interstitialAd;

                                    Log.e(TAG, "interstitial ad: loaded success: 1st attempt");
                                    interstitialAd1.setFullScreenContentCallback
                                            (new FullScreenContentCallback(){
                                                @Override
                                                public void onAdDismissedFullScreenContent() {
                                                    // Called when fullscreen content is dismissed.
                                                    Log.d(TAG, "interstitial ad: The ad was dismissed.");
                                                    getSwitch(activity);

                                                }

                                                @Override
                                                public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                    // Called when fullscreen content failed to show.
                                                    Log.d(TAG, "interstitial ad: The ad failed to show.");
                                                    getSwitch(activity);
                                                }

                                                @Override
                                                public void onAdShowedFullScreenContent() {
                                                    // Called when fullscreen content is shown.
                                                    // Make sure to set your reference to null so you don't
                                                    // show it a second time.
                                                    interstitialAd1 = null;
                                                    Log.d(TAG, "interstitial ad: The ad was shown.");
                                                }
                                            });
                                }

                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    // Handle the error
                                    Log.e(TAG, "interstitial ad: loading failed: "+loadAdError.getMessage());
                                    Log.e(TAG,"interstitial ad: loading failed " + loadAdError.toString());
                                    Log.e(TAG,"interstitial ad: loading failed " + loadAdError.getDomain());
                                    Log.e(TAG,"interstitial ad: loading failed " + loadAdError.getResponseInfo());
                                    Log.e(TAG,"interstitial ad: loading failed " + loadAdError.getCause());
                                    interstitialAd1 = null;
                                }
                            });
                }
            },1000);
    }

    //... show interstitial ad
    public static void showAdmobInterstitial(Activity activity){

        if (interstitialAd1 != null){
            interstitialAd1.show(activity);
            loadAdmobInterstitialAd(activity);
            Log.e(TAG, "interstitial ad: already loaded: ad shown successfully "
                    +activity.getLocalClassName());
        }
        else {
            getSwitch(activity);
                loadAdmobInterstitialAd(activity);
            Log.e(TAG, "interstitial ad: loading again 2nd attempt"
                    +activity.getLocalClassName());
        }
    }

//    public static void FullPlayerActivity(Activity activity){
//        Intent intent = new Intent(activity, AllVideos.class);
//        intent.putExtra("from", "fullscreen");
//        activity.startActivity(intent);
//    }


    //..... show activity intent
    private static void getSwitch(Activity activity){
            switch (App_Const.INTENT_UTIL){
                case 1:
//                    FullPlayerActivity(activity);
//                    break;

                case 2:

                    //activity.startActivity(new Intent(activity, DataScreen.class));

                    break;

                case 3:
                    //activity.startActivity(new Intent(activity, GameScreen.class));
                    break;

                case 4:
                    //activity.startActivity(new Intent(activity, SavedMusic_Screen.class));

                    break;

                case 5:
                    //activity.startActivity(new Intent(activity, PdfBooksActivity.class));
                    break;

                case 6:
                    //activity.startActivity(new Intent(activity, Menu_Screen.class));
                    //activity.finish();
                    break;
            }
    }


    //...... method for load and show native ad
    public static void loadandshowAdmobNative(Activity activity,FrameLayout nativeAdContainerView) {
        if (isOnline(activity)){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {


                    adLoader= new AdLoader.Builder(activity, activity.getString(R.string.admob_native_id))
                            .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                                @Override
                                public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {

                                }
                            })
                            .withAdListener(new AdListener() {
                                @Override
                                public void onAdClicked() {
                                    super.onAdClicked();
                                }

                                @Override
                                public void onAdClosed() {
                                    super.onAdClosed();
                                }

                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    super.onAdFailedToLoad(loadAdError);
                                    Log.e(TAG, "native ad : loading failed " +
                                            "" + loadAdError.toString());
                                    Log.e(TAG, "native ad: loading failed " + loadAdError.toString());
                                    Log.e(TAG, "native ad: loading failed " + loadAdError.getDomain());
                                    Log.e(TAG, "native ad: loading failed " + loadAdError.getResponseInfo());
                                    Log.e(TAG, "native ad: loading failed " + loadAdError.getCause());

                                }

                                @Override
                                public void onAdImpression() {
                                    super.onAdImpression();
                                }

                                @Override
                                public void onAdLoaded() {
                                    super.onAdLoaded();
                                }

                                @Override
                                public void onAdOpened() {
                                    super.onAdOpened();
                                }
                            }).build();

                    adLoader.loadAd(new AdRequest.Builder().build());


                    if (nativeAd1 != null){
                        nativeContainer = nativeAdContainerView.findViewById(R.id.native_container);
                        nativeAdView = (NativeAdView) activity.getLayoutInflater()
                                .inflate(R.layout.mediation_native_ad, null);

                        populateNativeAdView(nativeAd1, nativeAdView);
                        nativeContainer.removeAllViews();
                        nativeContainer.addView(nativeAdView);
                        Log.e(TAG,"native ad: already loaded ,ad shown successfully "
                                +activity.getLocalClassName());
                    }
                    else  {
                        loadNativeAdAfterInternetConnected(activity, nativeAdContainerView);
                        Log.e(TAG, "native ad: connected to internet, loading native..., "
                                +activity.getLocalClassName());
                    }
/*
                    //FrameLayout nativeAdContainerView = activity.findViewById(R.id.frameLayout);
                    nativeAdLoader = new MaxNativeAdLoader( activity
                            .getString(R.string.native_id),activity);
                    nativeAdLoader.setRevenueListener(new MaxAdRevenueListener() {
                        @Override
                        public void onAdRevenuePaid(MaxAd ad) {
                        }
                    });
                    nativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                        @Override
                        public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView,
                                                     MaxAd maxAd) {
                            super.onNativeAdLoaded(maxNativeAdView, maxAd);
                            // Clean up any pre-existing native ad to prevent memory leaks.
                            if ( nativeAd != null )
                            {
                                nativeAdLoader.destroy( nativeAd );

                            }
                            // Save ad for cleanup.
                            nativeAd = maxAd;
                            nativeAdContainerView.removeAllViews();
                            nativeAdContainerView.addView( maxNativeAdView );
                            Log.e(TAG,"native ad: loaded success,");
                        }

                        @Override
                        public void onNativeAdLoadFailed(String s, MaxError maxError) {
                            super.onNativeAdLoadFailed(s, maxError);
                            Log.e("native error:",maxError.getMessage());
                            Log.e("native code:", String.valueOf(maxError.getCode()));
                        }
                        @Override
                        public void onNativeAdClicked(MaxAd maxAd) {
                            super.onNativeAdClicked(maxAd);
                        }
                    });
                    loadNativeAd(activity);*/
                }
            },1000);
        }
        else {
            Log.e(TAG, "native ad: cannot load no internet,");
        }
    }

    //....... check internet connection
    public static boolean isOnline(Activity activity) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                        .getState() == NetworkInfo.State.CONNECTED) {
            //.....connected to a network
            connected = true;
        } else {
            connected = false;
        }
        return connected;
    }


}