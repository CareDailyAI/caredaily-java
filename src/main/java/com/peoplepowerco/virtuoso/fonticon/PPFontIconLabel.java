package com.peoplepowerco.virtuoso.fonticon;


import android.content.Context;
import android.graphics.Typeface;

import android.text.TextUtils;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;
import java.io.InputStream;

public class PPFontIconLabel {

    private static final String TAG = PPFontIconLabel.class.getSimpleName();
    private Context mContext = null;
    // PPC IOT Font Icon Names
    public static final String ICON_360 = "360";
    public static final String ICON_2WAY_VIDEO = "2way-video";
    public static final String ICON_BUDGET = "budget";
    public static final String ICON_CAMERA_ANDROID = "camera-android";
    public static final String ICON_CAMERA_GALILEO = "camera-galileo";
    public static final String ICON_CAMERA_IOS = "camera-ios";
    public static final String ICON_CAMERA_KUBI = "camera-kubi";
    public static final String ICON_CAMERA = "camera";
    public static final String ICON_CHALLENGES_ALERT = "challenges-alert";
    public static final String ICON_DRYER = "dryer";
    public static final String ICON_CALL_CENTER = "call-center";
    public static final String ICON_ENTRY = "entry";
    public static final String ICON_FACEBOOK = "facebook";
    public static final String ICON_FAQ = "faq";
    public static final String ICON_FEEDBACK_CROWD = "feedback-crowd";
    public static final String ICON_FEEDBACK_FEATURE = "feedback-feature";
    public static final String ICON_FEEDBACK_PRO = "feedback-pro";
    public static final String ICON_FLASHLIGHT_OFF = "flashlight-off";
    public static final String ICON_FLIP_CAMERA = "flip-camera";
    public static final String ICON_FRIENDS = "friends";
    public static final String ICON_GEOFENCING = "geofencing";
    public static final String ICON_GET_PRO = "get-pro";
    public static final String ICON_HUMIDITY = "humidity";
    public static final String ICON_LEVEL_1 = "level-1";
    public static final String ICON_LEVEL_2 = "level-2";
    public static final String ICON_LEVEL_3 = "level-3";
    public static final String ICON_LEVEL_4 = "level-4";
    public static final String ICON_LEVEL_5 = "level-5";
    public static final String ICON_MESSAGES_ALERT = "messages-alert";
    public static final String ICON_MOTION_RECORDING = "motion-recording";
    public static final String ICON_MOTION = "motion";
    public static final String ICON_CAMERA_IP = "camera-ip";
    public static final String ICON_PHONE_ALERT = "phone-alert";
    public static final String ICON_PHONE = "phone";
    public static final String ICON_PILL = "pill";
    public static final String ICON_PLUG = "plug";
    public static final String ICON_POINTS = "points";
    public static final String ICON_PRESENCE_PRO = "presence-pro";
    public static final String ICON_PRESENCE = "presence";
    public static final String ICON_RECORDING_TIME = "recording-time";
    public static final String ICON_RECOVER = "recover";
    public static final String ICON_REMOTE = "remote";
    public static final String ICON_RULES = "rules";
    public static final String ICON_SENSITIVITY = "sensitivity";
    public static final String ICON_SHARE_ALERTS = "share-alerts";
    public static final String ICON_SIGN_OUT = "sign-out";
    public static final String ICON_STICKER = "sticker";
    public static final String ICON_TEMPERATURE = "temperature";
    public static final String ICON_THERMOSTAT = "thermostat";
    public static final String ICON_TIME_FORMAT = "time-format";
    public static final String ICON_TIMEZONE = "timezone";
    public static final String ICON_TOUCH = "touch";
    public static final String ICON_TWITTER = "twitter";
    public static final String ICON_USER_BACK = "user-back";
    public static final String ICON_VIDEO_QUALITY = "video-quality";
    public static final String ICON_VIDEO_SETTINGS = "video-settings";
    public static final String ICON_WATER = "water";
    public static final String ICON_YOUTUBE = "youtube";
    public static final String ICON_POLICE = "police";
    public static final String ICON_USER_ADD = "user-add";
    public static final String ICON_SWITCH = "switch";
    public static final String ICON_AWAY = "away";
    public static final String ICON_HOME = "home";
    public static final String ICON_KEYPAD = "keypad";
    public static final String ICON_SIREN = "siren";
    public static final String ICON_SLEEP = "sleep";
    public static final String ICON_TEST = "test";
    public static final String ICON_VACATION = "vacation";
    public static final String ICON_FINGERPRINT_CIRCLE = "fingerprint-circle";
    public static final String ICON_KEY_CIRCLE = "key-circle";
    public static final String ICON_KEYPAD_CIRCLE = "keypad-circle";
    public static final String ICON_MUTE_CIRCLE = "mute-circle";
    public static final String ICON_UNMUTE_CIRCLE = "unmute-circle";
    public static final String ICON_AIR = "air";
    public static final String ICON_WEATHER = "weather";
    public static final String ICON_STAY = "stay";
    public static final String ICON_LEAF = "leaf";
    public static final String ICON_NOISE = "noise";
    public static final String ICON_PRESSURE = "pressure";
    public static final String ICON_AC = "ac";
    public static final String ICON_CONDITION = "condition";
    public static final String ICON_TOUCHPAD = "touchpad";
    public static final String ICON_TEMP_HUMIDITY = "temp-humidity";
    public static final String ICON_SECURITY_SETTINGS = "security-settings";
    public static final String ICON_SECURITY = "security";
    public static final String ICON_FACE_ID = "face-id";
    public static final String ICON_PACKAGE_PRO = "package-pro";
    public static final String ICON_PUSH_BUTTON = "push-button";
    public static final String ICON_RECORDING = "recording";
    public static final String ICON_USER_ADMIN = "user-admin";
    public static final String ICON_SMART_LOCK = "smartlock";
    public static final String ICON_CO2_DETECTOR = "co";

    // Weather Font Icon Names
    public static final String ICON_BAROMETER = "barometer";
    public static final String ICON_CELSIUS = "celsius";
    public static final String ICON_CLOUD = "cloud";
    public static final String ICON_CLOUD_DOWN = "cloud-down";
    public static final String ICON_CLOUD_REFRESH = "cloud-refresh";
    public static final String ICON_CLOUD_UP = "cloud-up";
    public static final String ICON_CLOUDY = "cloudy";
    public static final String ICON_CLOUDY_GUSTS = "cloudy-gusts";
    public static final String ICON_CLOUDY_WINDY = "cloudy-windy";
    public static final String ICON_DAY_CLOUDY = "day-cloudy";
    public static final String ICON_DAY_CLOUDY_GUSTS = "day-cloudy-gusts";
    public static final String ICON_DAY_CLOUDY_WINDY = "day-cloudy-windy";
    public static final String ICON_DAY_HAIL = "day-hail";
    public static final String ICON_DAY_HAZE = "day-haze";
    public static final String ICON_DAY_LIGHT_WIND = "day-light-wind";
    public static final String ICON_DAY_LIGHTNING = "day-lightning";
    public static final String ICON_DAY_RAIN = "day-rain";
    public static final String ICON_DAY_RAIN_MIX = "day-rain-mix";
    public static final String ICON_DAY_RAIN_WIND = "day-rain-wind";
    public static final String ICON_DAY_SHOWER = "day-shower";
    public static final String ICON_DAY_SLEET_STORM = "day-sleet-storm";
    public static final String ICON_DAY_SNOW = "day-snow";
    public static final String ICON_DAY_SUNNY = "day-sunny";
    public static final String ICON_DAY_SUNNY_OVERCAST = "day-sunny-overcast";
    public static final String ICON_DAY_WINDY = "day-windy";
    public static final String ICON_DUST = "dust";
    public static final String ICON_EARTHQUAKE = "earthquake";
    public static final String ICON_FARENHEIT = "farenheit";
    public static final String ICON_FIRE = "fire";
    public static final String ICON_FLOOD = "flood";
    public static final String ICON_FOG = "fog";
    public static final String ICON_HAIL = "hail";
    public static final String ICON_HORIZON = "horizon";
    public static final String ICON_HORIZON_ALT = "horizon-alt";
    public static final String ICON_HOT = "hot";
    public static final String ICON_HURRICANE = "hurricane";
    public static final String ICON_LIGHTNING = "lightning";
    public static final String ICON_LUNAR_ECLIPSE = "lunar-eclipse";
    public static final String ICON_METEOR = "meteor";
    public static final String ICON_NIGHT_ALT_CLOUDY = "night-alt-cloudy";
    public static final String ICON_NIGHT_ALT_CLOUDY_GUSTS = "night-alt-cloudy-gusts";
    public static final String ICON_NIGHT_ALT_CLOUDY_HIGH = "night-alt-cloudy-high";
    public static final String ICON_NIGHT_ALT_CLOUDY_WINDY = "night-alt-cloudy-windy";
    public static final String ICON_NIGHT_ALT_HAIL = "night-alt-hail";
    public static final String ICON_NIGHT_ALT_LIGHTNING = "night-alt-lightning";
    public static final String ICON_NIGHT_ALT_PARTLY_CLOUDY = "night-alt-partly-cloudy";
    public static final String ICON_NIGHT_ALT_RAIN = "night-alt-rain";
    public static final String ICON_NIGHT_ALT_RAIN_MIX = "night-alt-rain-mix";
    public static final String ICON_NIGHT_ALT_RAIN_WIND = "night-alt-rain-wind";
    public static final String ICON_NIGHT_ALT_SHOWERS = "night-alt-showers";
    public static final String ICON_NIGHT_ALT_SLEET = "night-alt-sleet";
    public static final String ICON_NIGHT_ALT_SNOW = "night-alt-snow";
    public static final String ICON_NIGHT_ALT_STORM_SHOWERS = "night-alt-storm-showers";
    public static final String ICON_NIGHT_ALT_THUNDERSTORM = "night-alt-thunderstorm";
    public static final String ICON_NIGHT_CLEAR = "night-clear";
    public static final String ICON_NIGHT_CLOUDY = "night-cloudy";
    public static final String ICON_NIGHT_CLOUDY_GUSTS = "night-cloudy-gusts";
    public static final String ICON_NIGHT_CLOUDY_HIGH = "night-cloudy-high";
    public static final String ICON_NIGHT_CLOUDY_WINDY = "night-cloudy-windy";
    public static final String ICON_NIGHT_FOG = "night-fog";
    public static final String ICON_NIGHT_HAIL = "night-hail";
    public static final String ICON_NIGHT_LIGHTNING = "night-lightning";
    public static final String ICON_NIGHT_PARTLY_CLOUDY = "night-partly-cloudy";
    public static final String ICON_NIGHT_RAIN = "night-rain";
    public static final String ICON_NIGHT_RAIN_MIX = "night-rain-mix";
    public static final String ICON_NIGHT_RAIN_WIND = "night-rain-wind";
    public static final String ICON_NIGHT_SHOWERS = "night-showers";
    public static final String ICON_NIGHT_SLEET_STORM = "night-sleet-storm";
    public static final String ICON_NIGHT_SNOW = "night-snow";
    public static final String ICON_NIGHT_SNOW_THUNDERSTORM = "night-snow-thunderstorm";
    public static final String ICON_NIGHT_SPRINKLE = "night-sprinkle";
    public static final String ICON_NIGHT_STORM_SHOWERS = "night-storm-showers";
    public static final String ICON_NIGHT_THUNDERSTORM = "night-thunderstorm";
    public static final String ICON_RAIN = "rain";
    public static final String ICON_RAIN_MIX = "rain-mix";
    public static final String ICON_RAIN_WIND = "rain-wind";
    public static final String ICON_RAINDROP = "raindrop";
    public static final String ICON_SANDSTORM = "sandstorm";
    public static final String ICON_SHOWERS = "showers";
    public static final String ICON_SLEET = "sleet";
    public static final String ICON_SNOW = "snow";
    public static final String ICON_SNOWFLAKE_COLD = "snowflake-cold";
    public static final String ICON_SOLAR_ECLIPSE = "solar-eclipse";
    public static final String ICON_SPRINKLE = "sprinkle";
    public static final String ICON_STORM_SHOWERS = "storm-showers";
    public static final String ICON_STRONG_WINDS = "strong-winds";
    public static final String ICON_SUNRISE = "sunrise";
    public static final String ICON_SUNSET = "sunset";
    public static final String ICON_THUNDERSTORM = "thunderstorm";
    public static final String ICON_TORNADO = "tornado";
    public static final String ICON_TSUNAMI = "tsunami";
    public static final String ICON_WINDY = "windy";

    // FA Font Icon Names
    public static final String ICON_FA_500PX = "500px";
    public static final String ICON_FA_ACCESSIBLE_ICON = "accessible-icon";
    public static final String ICON_FA_ACCUSOFT = "accusoft";
    public static final String ICON_FA_ADN = "adn";
    public static final String ICON_FA_ADVERSAL = "adversal";
    public static final String ICON_FA_AFFILIATETHEME = "affiliatetheme";
    public static final String ICON_FA_ALGOLIA = "algolia";
    public static final String ICON_FA_AMAZON = "amazon";
    public static final String ICON_FA_AMAZON_PAY = "amazon-pay";
    public static final String ICON_FA_AMILIA = "amilia";
    public static final String ICON_FA_ANDROID = "android";
    public static final String ICON_FA_ANGELLIST = "angellist";
    public static final String ICON_FA_ANGRYCREATIVE = "angrycreative";
    public static final String ICON_FA_ANGULAR = "angular";
    public static final String ICON_FA_APP_STORE = "app-store";
    public static final String ICON_FA_APP_STORE_IOS = "app-store-ios";
    public static final String ICON_FA_APPER = "apper";
    public static final String ICON_FA_APPLE = "apple";
    public static final String ICON_FA_APPLE_PAY = "apple-pay";
    public static final String ICON_FA_ASYMMETRIK = "asymmetrik";
    public static final String ICON_FA_AUDIBLE = "audible";
    public static final String ICON_FA_AUTOPREFIXER = "autoprefixer";
    public static final String ICON_FA_AVIANEX = "avianex";
    public static final String ICON_FA_AVIATO = "aviato";
    public static final String ICON_FA_AWS = "aws";
    public static final String ICON_FA_BANDCAMP = "bandcamp";
    public static final String ICON_FA_BEHANCE = "behance";
    public static final String ICON_FA_BEHANCE_SQUARE = "behance-square";
    public static final String ICON_FA_BIMOBJECT = "bimobject";
    public static final String ICON_FA_BITBUCKET = "bitbucket";
    public static final String ICON_FA_BITCOIN = "bitcoin";
    public static final String ICON_FA_BITY = "bity";
    public static final String ICON_FA_BLACK_TIE = "black-tie";
    public static final String ICON_FA_BLACKBERRY = "blackberry";
    public static final String ICON_FA_BLOGGER = "blogger";
    public static final String ICON_FA_BLOGGER_B = "blogger-b";
    public static final String ICON_FA_BLUETOOTH = "bluetooth";
    public static final String ICON_FA_BLUETOOTH_B = "bluetooth-b";
    public static final String ICON_FA_BTC = "btc";
    public static final String ICON_FA_BUROMOBELEXPERTE = "buromobelexperte";
    public static final String ICON_FA_BUYSELLADS = "buysellads";
    public static final String ICON_FA_CC_AMAZON_PAY = "cc-amazon-pay";
    public static final String ICON_FA_CC_AMEX = "cc-amex";
    public static final String ICON_FA_CC_APPLE_PAY = "cc-apple-pay";
    public static final String ICON_FA_CC_DINERS_CLUB = "cc-diners-club";
    public static final String ICON_FA_CC_DISCOVER = "cc-discover";
    public static final String ICON_FA_CC_JCB = "cc-jcb";
    public static final String ICON_FA_CC_MASTERCARD = "cc-mastercard";
    public static final String ICON_FA_CC_PAYPAL = "cc-paypal";
    public static final String ICON_FA_CC_STRIPE = "cc-stripe";
    public static final String ICON_FA_CC_VISA = "cc-visa";
    public static final String ICON_FA_CENTERCODE = "centercode";
    public static final String ICON_FA_CHROME = "chrome";
    public static final String ICON_FA_CLOUDSCALE = "cloudscale";
    public static final String ICON_FA_CLOUDSMITH = "cloudsmith";
    public static final String ICON_FA_CLOUDVERSIFY = "cloudversify";
    public static final String ICON_FA_CODEPEN = "codepen";
    public static final String ICON_FA_CODIEPIE = "codiepie";
    public static final String ICON_FA_CONNECTDEVELOP = "connectdevelop";
    public static final String ICON_FA_CONTAO = "contao";
    public static final String ICON_FA_CPANEL = "cpanel";
    public static final String ICON_FA_CREATIVE_COMMONS = "creative-commons";
    public static final String ICON_FA_CSS3 = "css3";
    public static final String ICON_FA_CSS3_ALT = "css3-alt";
    public static final String ICON_FA_CUTTLEFISH = "cuttlefish";
    public static final String ICON_FA_D_AND_D = "d-and-d";
    public static final String ICON_FA_DASHCUBE = "dashcube";
    public static final String ICON_FA_DELICIOUS = "delicious";
    public static final String ICON_FA_DEPLOYDOG = "deploydog";
    public static final String ICON_FA_DESKPRO = "deskpro";
    public static final String ICON_FA_DEVIANTART = "deviantart";
    public static final String ICON_FA_DIGG = "digg";
    public static final String ICON_FA_DIGITAL_OCEAN = "digital-ocean";
    public static final String ICON_FA_DISCORD = "discord";
    public static final String ICON_FA_DISCOURSE = "discourse";
    public static final String ICON_FA_DOCHUB = "dochub";
    public static final String ICON_FA_DOCKER = "docker";
    public static final String ICON_FA_DRAFT2DIGITAL = "draft2digital";
    public static final String ICON_FA_DRIBBBLE = "dribbble";
    public static final String ICON_FA_DRIBBBLE_SQUARE = "dribbble-square";
    public static final String ICON_FA_DROPBOX = "dropbox";
    public static final String ICON_FA_DRUPAL = "drupal";
    public static final String ICON_FA_DYALOG = "dyalog";
    public static final String ICON_FA_EARLYBIRDS = "earlybirds";
    public static final String ICON_FA_EDGE = "edge";
    public static final String ICON_FA_ELEMENTOR = "elementor";
    public static final String ICON_FA_EMBER = "ember";
    public static final String ICON_FA_EMPIRE = "empire";
    public static final String ICON_FA_ENVIRA = "envira";
    public static final String ICON_FA_ERLANG = "erlang";
    public static final String ICON_FA_ETHEREUM = "ethereum";
    public static final String ICON_FA_ETHERNET = "ethernet";
    public static final String ICON_FA_ETSY = "etsy";
    public static final String ICON_FA_EXPEDITEDSSL = "expeditedssl";
    public static final String ICON_FA_FACEBOOK = "facebook";
    public static final String ICON_FA_FACEBOOK_F = "facebook-f";
    public static final String ICON_FA_FACEBOOK_MESSENGER = "facebook-messenger";
    public static final String ICON_FA_FACEBOOK_SQUARE = "facebook-square";
    public static final String ICON_FA_FIREFOX = "firefox";
    public static final String ICON_FA_FIRST_ORDER = "first-order";
    public static final String ICON_FA_FIRSTDRAFT = "firstdraft";
    public static final String ICON_FA_FLICKR = "flickr";
    public static final String ICON_FA_FLY = "fly";
    public static final String ICON_FA_FONT_AWESOME = "font-awesome";
    public static final String ICON_FA_FONT_AWESOME_ALT = "font-awesome-alt";
    public static final String ICON_FA_FONT_AWESOME_FLAG = "font-awesome-flag";
    public static final String ICON_FA_FONTICONS = "fonticons";
    public static final String ICON_FA_FONTICONS_FI = "fonticons-fi";
    public static final String ICON_FA_FORT_AWESOME = "fort-awesome";
    public static final String ICON_FA_FORT_AWESOME_ALT = "fort-awesome-alt";
    public static final String ICON_FA_FORUMBEE = "forumbee";
    public static final String ICON_FA_FOURSQUARE = "foursquare";
    public static final String ICON_FA_FREE_CODE_CAMP = "free-code-camp";
    public static final String ICON_FA_FREEBSD = "freebsd";
    public static final String ICON_FA_GET_POCKET = "get-pocket";
    public static final String ICON_FA_GG = "gg";
    public static final String ICON_FA_GG_CIRCLE = "gg-circle";
    public static final String ICON_FA_GIT = "git";
    public static final String ICON_FA_GIT_SQUARE = "git-square";
    public static final String ICON_FA_GITHUB = "github";
    public static final String ICON_FA_GITHUB_ALT = "github-alt";
    public static final String ICON_FA_GITHUB_SQUARE = "github-square";
    public static final String ICON_FA_GITKRAKEN = "gitkraken";
    public static final String ICON_FA_GITLAB = "gitlab";
    public static final String ICON_FA_GITTER = "gitter";
    public static final String ICON_FA_GLIDE = "glide";
    public static final String ICON_FA_GLIDE_G = "glide-g";
    public static final String ICON_FA_GOFORE = "gofore";
    public static final String ICON_FA_GOODREADS = "goodreads";
    public static final String ICON_FA_GOODREADS_G = "goodreads-g";
    public static final String ICON_FA_GOOGLE = "google";
    public static final String ICON_FA_GOOGLE_DRIVE = "google-drive";
    public static final String ICON_FA_GOOGLE_PLAY = "google-play";
    public static final String ICON_FA_GOOGLE_PLUS = "google-plus";
    public static final String ICON_FA_GOOGLE_PLUS_G = "google-plus-g";
    public static final String ICON_FA_GOOGLE_PLUS_SQUARE = "google-plus-square";
    public static final String ICON_FA_GOOGLE_WALLET = "google-wallet";
    public static final String ICON_FA_GRATIPAY = "gratipay";
    public static final String ICON_FA_GRAV = "grav";
    public static final String ICON_FA_GRIPFIRE = "gripfire";
    public static final String ICON_FA_GRUNT = "grunt";
    public static final String ICON_FA_GULP = "gulp";
    public static final String ICON_FA_HACKER_NEWS = "hacker-news";
    public static final String ICON_FA_HACKER_NEWS_SQUARE = "hacker-news-square";
    public static final String ICON_FA_HIRE_A_HELPER = "hire-a-helper";
    public static final String ICON_FA_HOOLI = "hooli";
    public static final String ICON_FA_HOTJAR = "hotjar";
    public static final String ICON_FA_HOUZZ = "houzz";
    public static final String ICON_FA_HTML5 = "html5";
    public static final String ICON_FA_HUBSPOT = "hubspot";
    public static final String ICON_FA_IMDB = "imdb";
    public static final String ICON_FA_INSTAGRAM = "instagram";
    public static final String ICON_FA_INTERNET_EXPLORER = "internet-explorer";
    public static final String ICON_FA_IOXHOST = "ioxhost";
    public static final String ICON_FA_ITUNES = "itunes";
    public static final String ICON_FA_ITUNES_NOTE = "itunes-note";
    public static final String ICON_FA_JENKINS = "jenkins";
    public static final String ICON_FA_JOGET = "joget";
    public static final String ICON_FA_JOOMLA = "joomla";
    public static final String ICON_FA_JS = "js";
    public static final String ICON_FA_JS_SQUARE = "js-square";
    public static final String ICON_FA_JSFIDDLE = "jsfiddle";
    public static final String ICON_FA_KEYCDN = "keycdn";
    public static final String ICON_FA_KICKSTARTER = "kickstarter";
    public static final String ICON_FA_KICKSTARTER_K = "kickstarter-k";
    public static final String ICON_FA_KORVUE = "korvue";
    public static final String ICON_FA_LARAVEL = "laravel";
    public static final String ICON_FA_LASTFM = "lastfm";
    public static final String ICON_FA_LASTFM_SQUARE = "lastfm-square";
    public static final String ICON_FA_LEANPUB = "leanpub";
    public static final String ICON_FA_LESS = "less";
    public static final String ICON_FA_LINE = "line";
    public static final String ICON_FA_LINKEDIN = "linkedin";
    public static final String ICON_FA_LINKEDIN_IN = "linkedin-in";
    public static final String ICON_FA_LINODE = "linode";
    public static final String ICON_FA_LINUX = "linux";
    public static final String ICON_FA_LYFT = "lyft";
    public static final String ICON_FA_MAGENTO = "magento";
    public static final String ICON_FA_MAXCDN = "maxcdn";
    public static final String ICON_FA_MEDAPPS = "medapps";
    public static final String ICON_FA_MEDIUM = "medium";
    public static final String ICON_FA_MEDIUM_M = "medium-m";
    public static final String ICON_FA_MEDRT = "medrt";
    public static final String ICON_FA_MEETUP = "meetup";
    public static final String ICON_FA_MICROSOFT = "microsoft";
    public static final String ICON_FA_MIX = "mix";
    public static final String ICON_FA_MIXCLOUD = "mixcloud";
    public static final String ICON_FA_MIZUNI = "mizuni";
    public static final String ICON_FA_MODX = "modx";
    public static final String ICON_FA_MONERO = "monero";
    public static final String ICON_FA_NAPSTER = "napster";
    public static final String ICON_FA_NINTENDO_SWITCH = "nintendo-switch";
    public static final String ICON_FA_NODE = "node";
    public static final String ICON_FA_NODE_JS = "node-js";
    public static final String ICON_FA_NPM = "npm";
    public static final String ICON_FA_NS8 = "ns8";
    public static final String ICON_FA_NUTRITIONIX = "nutritionix";
    public static final String ICON_FA_ODNOKLASSNIKI = "odnoklassniki";
    public static final String ICON_FA_ODNOKLASSNIKI_SQUARE = "odnoklassniki-square";
    public static final String ICON_FA_OPENCART = "opencart";
    public static final String ICON_FA_OPENID = "openid";
    public static final String ICON_FA_OPERA = "opera";
    public static final String ICON_FA_OPTIN_MONSTER = "optin-monster";
    public static final String ICON_FA_OSI = "osi";
    public static final String ICON_FA_PAGE4 = "page4";
    public static final String ICON_FA_PAGELINES = "pagelines";
    public static final String ICON_FA_PALFED = "palfed";
    public static final String ICON_FA_PATREON = "patreon";
    public static final String ICON_FA_PAYPAL = "paypal";
    public static final String ICON_FA_PERISCOPE = "periscope";
    public static final String ICON_FA_PHABRICATOR = "phabricator";
    public static final String ICON_FA_PHOENIX_FRAMEWORK = "phoenix-framework";
    public static final String ICON_FA_PIED_PIPER = "pied-piper";
    public static final String ICON_FA_PIED_PIPER_ALT = "pied-piper-alt";
    public static final String ICON_FA_PIED_PIPER_PP = "pied-piper-pp";
    public static final String ICON_FA_PINTEREST = "pinterest";
    public static final String ICON_FA_PINTEREST_P = "pinterest-p";
    public static final String ICON_FA_PINTEREST_SQUARE = "pinterest-square";
    public static final String ICON_FA_PLAYSTATION = "playstation";
    public static final String ICON_FA_PRODUCT_HUNT = "product-hunt";
    public static final String ICON_FA_PUSHED = "pushed";
    public static final String ICON_FA_PYTHON = "python";
    public static final String ICON_FA_QQ = "qq";
    public static final String ICON_FA_QUORA = "quora";
    public static final String ICON_FA_RAVELRY = "ravelry";
    public static final String ICON_FA_REACT = "react";
    public static final String ICON_FA_REBEL = "rebel";
    public static final String ICON_FA_RED_RIVER = "red-river";
    public static final String ICON_FA_REDDIT = "reddit";
    public static final String ICON_FA_REDDIT_ALIEN = "reddit-alien";
    public static final String ICON_FA_REDDIT_SQUARE = "reddit-square";
    public static final String ICON_FA_RENDACT = "rendact";
    public static final String ICON_FA_RENREN = "renren";
    public static final String ICON_FA_REPLYD = "replyd";
    public static final String ICON_FA_RESOLVING = "resolving";
    public static final String ICON_FA_ROCKETCHAT = "rocketchat";
    public static final String ICON_FA_ROCKRMS = "rockrms";
    public static final String ICON_FA_SAFARI = "safari";
    public static final String ICON_FA_SASS = "sass";
    public static final String ICON_FA_SCHLIX = "schlix";
    public static final String ICON_FA_SCRIBD = "scribd";
    public static final String ICON_FA_SEARCHENGIN = "searchengin";
    public static final String ICON_FA_SELLCAST = "sellcast";
    public static final String ICON_FA_SELLSY = "sellsy";
    public static final String ICON_FA_SERVICESTACK = "servicestack";
    public static final String ICON_FA_SHIRTSINBULK = "shirtsinbulk";
    public static final String ICON_FA_SIMPLYBUILT = "simplybuilt";
    public static final String ICON_FA_SISTRIX = "sistrix";
    public static final String ICON_FA_SKYATLAS = "skyatlas";
    public static final String ICON_FA_SKYPE = "skype";
    public static final String ICON_FA_SLACK = "slack";
    public static final String ICON_FA_SLACK_HASH = "slack-hash";
    public static final String ICON_FA_SLIDESHARE = "slideshare";
    public static final String ICON_FA_SNAPCHAT = "snapchat";
    public static final String ICON_FA_SNAPCHAT_GHOST = "snapchat-ghost";
    public static final String ICON_FA_SNAPCHAT_SQUARE = "snapchat-square";
    public static final String ICON_FA_SOUNDCLOUD = "soundcloud";
    public static final String ICON_FA_SPEAKAP = "speakap";
    public static final String ICON_FA_SPOTIFY = "spotify";
    public static final String ICON_FA_STACK_EXCHANGE = "stack-exchange";
    public static final String ICON_FA_STACK_OVERFLOW = "stack-overflow";
    public static final String ICON_FA_STAYLINKED = "staylinked";
    public static final String ICON_FA_STEAM = "steam";
    public static final String ICON_FA_STEAM_SQUARE = "steam-square";
    public static final String ICON_FA_STEAM_SYMBOL = "steam-symbol";
    public static final String ICON_FA_STICKER_MULE = "sticker-mule";
    public static final String ICON_FA_STRAVA = "strava";
    public static final String ICON_FA_STRIPE = "stripe";
    public static final String ICON_FA_STRIPE_S = "stripe-s";
    public static final String ICON_FA_STUDIOVINARI = "studiovinari";
    public static final String ICON_FA_STUMBLEUPON = "stumbleupon";
    public static final String ICON_FA_STUMBLEUPON_CIRCLE = "stumbleupon-circle";
    public static final String ICON_FA_SUPERPOWERS = "superpowers";
    public static final String ICON_FA_SUPPLE = "supple";
    public static final String ICON_FA_TELEGRAM = "telegram";
    public static final String ICON_FA_TELEGRAM_PLANE = "telegram-plane";
    public static final String ICON_FA_TENCENT_WEIBO = "tencent-weibo";
    public static final String ICON_FA_THEMEISLE = "themeisle";
    public static final String ICON_FA_TRELLO = "trello";
    public static final String ICON_FA_TRIPADVISOR = "tripadvisor";
    public static final String ICON_FA_TUMBLR = "tumblr";
    public static final String ICON_FA_TUMBLR_SQUARE = "tumblr-square";
    public static final String ICON_FA_TWITCH = "twitch";
    public static final String ICON_FA_TWITTER = "twitter";
    public static final String ICON_FA_TWITTER_SQUARE = "twitter-square";
    public static final String ICON_FA_TYPO3 = "typo3";
    public static final String ICON_FA_UBER = "uber";
    public static final String ICON_FA_UIKIT = "uikit";
    public static final String ICON_FA_UNIREGISTRY = "uniregistry";
    public static final String ICON_FA_UNTAPPD = "untappd";
    public static final String ICON_FA_USB = "usb";
    public static final String ICON_FA_USSUNNAH = "ussunnah";
    public static final String ICON_FA_VAADIN = "vaadin";
    public static final String ICON_FA_VIACOIN = "viacoin";
    public static final String ICON_FA_VIADEO = "viadeo";
    public static final String ICON_FA_VIADEO_SQUARE = "viadeo-square";
    public static final String ICON_FA_VIBER = "viber";
    public static final String ICON_FA_VIMEO = "vimeo";
    public static final String ICON_FA_VIMEO_SQUARE = "vimeo-square";
    public static final String ICON_FA_VIMEO_V = "vimeo-v";
    public static final String ICON_FA_VINE = "vine";
    public static final String ICON_FA_VK = "vk";
    public static final String ICON_FA_VNV = "vnv";
    public static final String ICON_FA_VUEJS = "vuejs";
    public static final String ICON_FA_WEIBO = "weibo";
    public static final String ICON_FA_WEIXIN = "weixin";
    public static final String ICON_FA_WHATSAPP = "whatsapp";
    public static final String ICON_FA_WHATSAPP_SQUARE = "whatsapp-square";
    public static final String ICON_FA_WHMCS = "whmcs";
    public static final String ICON_FA_WIKIPEDIA_W = "wikipedia-w";
    public static final String ICON_FA_WINDOWS = "windows";
    public static final String ICON_FA_WORDPRESS = "wordpress";
    public static final String ICON_FA_WORDPRESS_SIMPLE = "wordpress-simple";
    public static final String ICON_FA_WPBEGINNER = "wpbeginner";
    public static final String ICON_FA_WPEXPLORER = "wpexplorer";
    public static final String ICON_FA_WPFORMS = "wpforms";
    public static final String ICON_FA_XBOX = "xbox";
    public static final String ICON_FA_XING = "xing";
    public static final String ICON_FA_XING_SQUARE = "xing-square";
    public static final String ICON_FA_Y_COMBINATOR = "y-combinator";
    public static final String ICON_FA_YAHOO = "yahoo";
    public static final String ICON_FA_YANDEX = "yandex";
    public static final String ICON_FA_YANDEX_INTERNATIONAL = "yandex-international";
    public static final String ICON_FA_YELP = "yelp";
    public static final String ICON_FA_YOAST = "yoast";
    public static final String ICON_FA_YOUTUBE = "youtube";
    public static final String ICON_FA_YOUTUBE_SQUARE = "youtube-square";
    public static final String ICON_FA_ADDRESS_BOOK = "address-book";
    public static final String ICON_FA_ADDRESS_CARD = "address-card";
    public static final String ICON_FA_ADJUST = "adjust";
    public static final String ICON_FA_ALARM_CLOCK = "alarm-clock";
    public static final String ICON_FA_ALIGN_CENTER = "align-center";
    public static final String ICON_FA_ALIGN_JUSTIFY = "align-justify";
    public static final String ICON_FA_ALIGN_LEFT = "align-left";
    public static final String ICON_FA_ALIGN_RIGHT = "align-right";
    public static final String ICON_FA_AMBULANCE = "ambulance";
    public static final String ICON_FA_AMERICAN_SIGN_LANGUAGE_INTERPRETING = "american-sign-language-interpreting";
    public static final String ICON_FA_ANCHOR = "anchor";
    public static final String ICON_FA_ANGLE_DOUBLE_DOWN = "angle-double-down";
    public static final String ICON_FA_ANGLE_DOUBLE_LEFT = "angle-double-left";
    public static final String ICON_FA_ANGLE_DOUBLE_RIGHT = "angle-double-right";
    public static final String ICON_FA_ANGLE_DOUBLE_UP = "angle-double-up";
    public static final String ICON_FA_ANGLE_DOWN = "angle-down";
    public static final String ICON_FA_ANGLE_LEFT = "angle-left";
    public static final String ICON_FA_ANGLE_RIGHT = "angle-right";
    public static final String ICON_FA_ANGLE_UP = "angle-up";
    public static final String ICON_FA_ARCHIVE = "archive";
    public static final String ICON_FA_ARROW_ALT_CIRCLE_DOWN = "arrow-alt-circle-down";
    public static final String ICON_FA_ARROW_ALT_CIRCLE_LEFT = "arrow-alt-circle-left";
    public static final String ICON_FA_ARROW_ALT_CIRCLE_RIGHT = "arrow-alt-circle-right";
    public static final String ICON_FA_ARROW_ALT_CIRCLE_UP = "arrow-alt-circle-up";
    public static final String ICON_FA_ARROW_ALT_DOWN = "arrow-alt-down";
    public static final String ICON_FA_ARROW_ALT_FROM_BOTTOM = "arrow-alt-from-bottom";
    public static final String ICON_FA_ARROW_ALT_FROM_LEFT = "arrow-alt-from-left";
    public static final String ICON_FA_ARROW_ALT_FROM_RIGHT = "arrow-alt-from-right";
    public static final String ICON_FA_ARROW_ALT_FROM_TOP = "arrow-alt-from-top";
    public static final String ICON_FA_ARROW_ALT_LEFT = "arrow-alt-left";
    public static final String ICON_FA_ARROW_ALT_RIGHT = "arrow-alt-right";
    public static final String ICON_FA_ARROW_ALT_SQUARE_DOWN = "arrow-alt-square-down";
    public static final String ICON_FA_ARROW_ALT_SQUARE_LEFT = "arrow-alt-square-left";
    public static final String ICON_FA_ARROW_ALT_SQUARE_RIGHT = "arrow-alt-square-right";
    public static final String ICON_FA_ARROW_ALT_SQUARE_UP = "arrow-alt-square-up";
    public static final String ICON_FA_ARROW_ALT_TO_BOTTOM = "arrow-alt-to-bottom";
    public static final String ICON_FA_ARROW_ALT_TO_LEFT = "arrow-alt-to-left";
    public static final String ICON_FA_ARROW_ALT_TO_RIGHT = "arrow-alt-to-right";
    public static final String ICON_FA_ARROW_ALT_TO_TOP = "arrow-alt-to-top";
    public static final String ICON_FA_ARROW_ALT_UP = "arrow-alt-up";
    public static final String ICON_FA_ARROW_CIRCLE_DOWN = "arrow-circle-down";
    public static final String ICON_FA_ARROW_CIRCLE_LEFT = "arrow-circle-left";
    public static final String ICON_FA_ARROW_CIRCLE_RIGHT = "arrow-circle-right";
    public static final String ICON_FA_ARROW_CIRCLE_UP = "arrow-circle-up";
    public static final String ICON_FA_ARROW_DOWN = "arrow-down";
    public static final String ICON_FA_ARROW_FROM_BOTTOM = "arrow-from-bottom";
    public static final String ICON_FA_ARROW_FROM_LEFT = "arrow-from-left";
    public static final String ICON_FA_ARROW_FROM_RIGHT = "arrow-from-right";
    public static final String ICON_FA_ARROW_FROM_TOP = "arrow-from-top";
    public static final String ICON_FA_ARROW_LEFT = "arrow-left";
    public static final String ICON_FA_ARROW_RIGHT = "arrow-right";
    public static final String ICON_FA_ARROW_SQUARE_DOWN = "arrow-square-down";
    public static final String ICON_FA_ARROW_SQUARE_LEFT = "arrow-square-left";
    public static final String ICON_FA_ARROW_SQUARE_RIGHT = "arrow-square-right";
    public static final String ICON_FA_ARROW_SQUARE_UP = "arrow-square-up";
    public static final String ICON_FA_ARROW_TO_BOTTOM = "arrow-to-bottom";
    public static final String ICON_FA_ARROW_TO_LEFT = "arrow-to-left";
    public static final String ICON_FA_ARROW_TO_RIGHT = "arrow-to-right";
    public static final String ICON_FA_ARROW_TO_TOP = "arrow-to-top";
    public static final String ICON_FA_ARROW_UP = "arrow-up";
    public static final String ICON_FA_ARROWS = "arrows";
    public static final String ICON_FA_ARROWS_ALT = "arrows-alt";
    public static final String ICON_FA_ARROWS_ALT_H = "arrows-alt-h";
    public static final String ICON_FA_ARROWS_ALT_V = "arrows-alt-v";
    public static final String ICON_FA_ARROWS_H = "arrows-h";
    public static final String ICON_FA_ARROWS_V = "arrows-v";
    public static final String ICON_FA_ASSISTIVE_LISTENING_SYSTEMS = "assistive-listening-systems";
    public static final String ICON_FA_ASTERISK = "asterisk";
    public static final String ICON_FA_AT = "at";
    public static final String ICON_FA_AUDIO_DESCRIPTION = "audio-description";
    public static final String ICON_FA_BACKWARD = "backward";
    public static final String ICON_FA_BADGE = "badge";
    public static final String ICON_FA_BADGE_CHECK = "badge-check";
    public static final String ICON_FA_BALANCE_SCALE = "balance-scale";
    public static final String ICON_FA_BALLOT = "ballot";
    public static final String ICON_FA_BAN = "ban";
    public static final String ICON_FA_BARCODE = "barcode";
    public static final String ICON_FA_BARS = "bars";
    public static final String ICON_FA_BATH = "bath";
    public static final String ICON_FA_BATTERY_BOLT = "battery-bolt";
    public static final String ICON_FA_BATTERY_EMPTY = "battery-empty";
    public static final String ICON_FA_BATTERY_FULL = "battery-full";
    public static final String ICON_FA_BATTERY_HALF = "battery-half";
    public static final String ICON_FA_BATTERY_QUARTER = "battery-quarter";
    public static final String ICON_FA_BATTERY_SLASH = "battery-slash";
    public static final String ICON_FA_BATTERY_THREE_QUARTERS = "battery-three-quarters";
    public static final String ICON_FA_BED = "bed";
    public static final String ICON_FA_BEER = "beer";
    public static final String ICON_FA_BELL = "bell";
    public static final String ICON_FA_BELL_SLASH = "bell-slash";
    public static final String ICON_FA_BICYCLE = "bicycle";
    public static final String ICON_FA_BINOCULARS = "binoculars";
    public static final String ICON_FA_BIRTHDAY_CAKE = "birthday-cake";
    public static final String ICON_FA_BLIND = "blind";
    public static final String ICON_FA_BOLD = "bold";
    public static final String ICON_FA_BOLT = "bolt";
    public static final String ICON_FA_BOMB = "bomb";
    public static final String ICON_FA_BOOK = "book";
    public static final String ICON_FA_BOOKMARK = "bookmark";
    public static final String ICON_FA_BRAILLE = "braille";
    public static final String ICON_FA_BRIEFCASE = "briefcase";
    public static final String ICON_FA_BROWSER = "browser";
    public static final String ICON_FA_BUG = "bug";
    public static final String ICON_FA_BUILDING = "building";
    public static final String ICON_FA_BULLHORN = "bullhorn";
    public static final String ICON_FA_BULLSEYE = "bullseye";
    public static final String ICON_FA_BUS = "bus";
    public static final String ICON_FA_CALCULATOR = "calculator";
    public static final String ICON_FA_CALENDAR = "calendar";
    public static final String ICON_FA_CALENDAR_ALT = "calendar-alt";
    public static final String ICON_FA_CALENDAR_CHECK = "calendar-check";
    public static final String ICON_FA_CALENDAR_EDIT = "calendar-edit";
    public static final String ICON_FA_CALENDAR_EXCLAMATION = "calendar-exclamation";
    public static final String ICON_FA_CALENDAR_MINUS = "calendar-minus";
    public static final String ICON_FA_CALENDAR_PLUS = "calendar-plus";
    public static final String ICON_FA_CALENDAR_TIMES = "calendar-times";
    public static final String ICON_FA_CAMERA = "camera";
    public static final String ICON_FA_CAMERA_ALT = "camera-alt";
    public static final String ICON_FA_CAMERA_RETRO = "camera-retro";
    public static final String ICON_FA_CAR = "car";
    public static final String ICON_FA_CARET_CIRCLE_DOWN = "caret-circle-down";
    public static final String ICON_FA_CARET_CIRCLE_LEFT = "caret-circle-left";
    public static final String ICON_FA_CARET_CIRCLE_RIGHT = "caret-circle-right";
    public static final String ICON_FA_CARET_CIRCLE_UP = "caret-circle-up";
    public static final String ICON_FA_CARET_DOWN = "caret-down";
    public static final String ICON_FA_CARET_LEFT = "caret-left";
    public static final String ICON_FA_CARET_RIGHT = "caret-right";
    public static final String ICON_FA_CARET_SQUARE_DOWN = "caret-square-down";
    public static final String ICON_FA_CARET_SQUARE_LEFT = "caret-square-left";
    public static final String ICON_FA_CARET_SQUARE_RIGHT = "caret-square-right";
    public static final String ICON_FA_CARET_SQUARE_UP = "caret-square-up";
    public static final String ICON_FA_CARET_UP = "caret-up";
    public static final String ICON_FA_CART_ARROW_DOWN = "cart-arrow-down";
    public static final String ICON_FA_CART_PLUS = "cart-plus";
    public static final String ICON_FA_CERTIFICATE = "certificate";
    public static final String ICON_FA_CHART_AREA = "chart-area";
    public static final String ICON_FA_CHART_BAR = "chart-bar";
    public static final String ICON_FA_CHART_LINE = "chart-line";
    public static final String ICON_FA_CHART_PIE = "chart-pie";
    public static final String ICON_FA_CHECK = "check";
    public static final String ICON_FA_CHECK_CIRCLE = "check-circle";
    public static final String ICON_FA_CHECK_SQUARE = "check-square";
    public static final String ICON_FA_CHEVRON_CIRCLE_DOWN = "chevron-circle-down";
    public static final String ICON_FA_CHEVRON_CIRCLE_LEFT = "chevron-circle-left";
    public static final String ICON_FA_CHEVRON_CIRCLE_RIGHT = "chevron-circle-right";
    public static final String ICON_FA_CHEVRON_CIRCLE_UP = "chevron-circle-up";
    public static final String ICON_FA_CHEVRON_DOUBLE_DOWN = "chevron-double-down";
    public static final String ICON_FA_CHEVRON_DOUBLE_LEFT = "chevron-double-left";
    public static final String ICON_FA_CHEVRON_DOUBLE_RIGHT = "chevron-double-right";
    public static final String ICON_FA_CHEVRON_DOUBLE_UP = "chevron-double-up";
    public static final String ICON_FA_CHEVRON_DOWN = "chevron-down";
    public static final String ICON_FA_CHEVRON_LEFT = "chevron-left";
    public static final String ICON_FA_CHEVRON_RIGHT = "chevron-right";
    public static final String ICON_FA_CHEVRON_SQUARE_DOWN = "chevron-square-down";
    public static final String ICON_FA_CHEVRON_SQUARE_LEFT = "chevron-square-left";
    public static final String ICON_FA_CHEVRON_SQUARE_RIGHT = "chevron-square-right";
    public static final String ICON_FA_CHEVRON_SQUARE_UP = "chevron-square-up";
    public static final String ICON_FA_CHEVRON_UP = "chevron-up";
    public static final String ICON_FA_CHILD = "child";
    public static final String ICON_FA_CIRCLE = "circle";
    public static final String ICON_FA_CIRCLE_NOTCH = "circle-notch";
    public static final String ICON_FA_CLIPBOARD = "clipboard";
    public static final String ICON_FA_CLOCK = "clock";
    public static final String ICON_FA_CLONE = "clone";
    public static final String ICON_FA_CLOSED_CAPTIONING = "closed-captioning";
    public static final String ICON_FA_CLOUD = "cloud";
    public static final String ICON_FA_CLOUD_DOWNLOAD = "cloud-download";
    public static final String ICON_FA_CLOUD_DOWNLOAD_ALT = "cloud-download-alt";
    public static final String ICON_FA_CLOUD_UPLOAD = "cloud-upload";
    public static final String ICON_FA_CLOUD_UPLOAD_ALT = "cloud-upload-alt";
    public static final String ICON_FA_CLUB = "club";
    public static final String ICON_FA_CODE = "code";
    public static final String ICON_FA_CODE_BRANCH = "code-branch";
    public static final String ICON_FA_CODE_COMMIT = "code-commit";
    public static final String ICON_FA_CODE_MERGE = "code-merge";
    public static final String ICON_FA_COFFEE = "coffee";
    public static final String ICON_FA_COG = "cog";
    public static final String ICON_FA_COGS = "cogs";
    public static final String ICON_FA_COLUMNS = "columns";
    public static final String ICON_FA_COMMENT = "comment";
    public static final String ICON_FA_COMMENT_ALT = "comment-alt";
    public static final String ICON_FA_COMMENTS = "comments";
    public static final String ICON_FA_COMPASS = "compass";
    public static final String ICON_FA_COMPRESS = "compress";
    public static final String ICON_FA_COMPRESS_ALT = "compress-alt";
    public static final String ICON_FA_COMPRESS_WIDE = "compress-wide";
    public static final String ICON_FA_COPY = "copy";
    public static final String ICON_FA_COPYRIGHT = "copyright";
    public static final String ICON_FA_CREDIT_CARD = "credit-card";
    public static final String ICON_FA_CREDIT_CARD_BLANK = "credit-card-blank";
    public static final String ICON_FA_CREDIT_CARD_FRONT = "credit-card-front";
    public static final String ICON_FA_CROP = "crop";
    public static final String ICON_FA_CROSSHAIRS = "crosshairs";
    public static final String ICON_FA_CUBE = "cube";
    public static final String ICON_FA_CUBES = "cubes";
    public static final String ICON_FA_CUT = "cut";
    public static final String ICON_FA_DATABASE = "database";
    public static final String ICON_FA_DEAF = "deaf";
    public static final String ICON_FA_DESKTOP = "desktop";
    public static final String ICON_FA_DESKTOP_ALT = "desktop-alt";
    public static final String ICON_FA_DIAMOND = "diamond";
    public static final String ICON_FA_DOLLAR_SIGN = "dollar-sign";
    public static final String ICON_FA_DOT_CIRCLE = "dot-circle";
    public static final String ICON_FA_DOWNLOAD = "download";
    public static final String ICON_FA_EDIT = "edit";
    public static final String ICON_FA_EJECT = "eject";
    public static final String ICON_FA_ELLIPSIS_H = "ellipsis-h";
    public static final String ICON_FA_ELLIPSIS_H_ALT = "ellipsis-h-alt";
    public static final String ICON_FA_ELLIPSIS_V = "ellipsis-v";
    public static final String ICON_FA_ELLIPSIS_V_ALT = "ellipsis-v-alt";
    public static final String ICON_FA_ENVELOPE = "envelope";
    public static final String ICON_FA_ENVELOPE_OPEN = "envelope-open";
    public static final String ICON_FA_ENVELOPE_SQUARE = "envelope-square";
    public static final String ICON_FA_ERASER = "eraser";
    public static final String ICON_FA_EURO_SIGN = "euro-sign";
    public static final String ICON_FA_EXCHANGE = "exchange";
    public static final String ICON_FA_EXCHANGE_ALT = "exchange-alt";
    public static final String ICON_FA_EXCLAMATION = "exclamation";
    public static final String ICON_FA_EXCLAMATION_CIRCLE = "exclamation-circle";
    public static final String ICON_FA_EXCLAMATION_SQUARE = "exclamation-square";
    public static final String ICON_FA_EXCLAMATION_TRIANGLE = "exclamation-triangle";
    public static final String ICON_FA_EXPAND = "expand";
    public static final String ICON_FA_EXPAND_ALT = "expand-alt";
    public static final String ICON_FA_EXPAND_ARROWS = "expand-arrows";
    public static final String ICON_FA_EXPAND_ARROWS_ALT = "expand-arrows-alt";
    public static final String ICON_FA_EXPAND_WIDE = "expand-wide";
    public static final String ICON_FA_EXTERNAL_LINK = "external-link";
    public static final String ICON_FA_EXTERNAL_LINK_ALT = "external-link-alt";
    public static final String ICON_FA_EXTERNAL_LINK_SQUARE = "external-link-square";
    public static final String ICON_FA_EXTERNAL_LINK_SQUARE_ALT = "external-link-square-alt";
    public static final String ICON_FA_EYE = "eye";
    public static final String ICON_FA_EYE_DROPPER = "eye-dropper";
    public static final String ICON_FA_EYE_SLASH = "eye-slash";
    public static final String ICON_FA_FAST_BACKWARD = "fast-backward";
    public static final String ICON_FA_FAST_FORWARD = "fast-forward";
    public static final String ICON_FA_FAX = "fax";
    public static final String ICON_FA_FEMALE = "female";
    public static final String ICON_FA_FIGHTER_JET = "fighter-jet";
    public static final String ICON_FA_FILE = "file";
    public static final String ICON_FA_FILE_ALT = "file-alt";
    public static final String ICON_FA_FILE_ARCHIVE = "file-archive";
    public static final String ICON_FA_FILE_AUDIO = "file-audio";
    public static final String ICON_FA_FILE_CHECK = "file-check";
    public static final String ICON_FA_FILE_CODE = "file-code";
    public static final String ICON_FA_FILE_EDIT = "file-edit";
    public static final String ICON_FA_FILE_EXCEL = "file-excel";
    public static final String ICON_FA_FILE_EXCLAMATION = "file-exclamation";
    public static final String ICON_FA_FILE_IMAGE = "file-image";
    public static final String ICON_FA_FILE_MINUS = "file-minus";
    public static final String ICON_FA_FILE_PDF = "file-pdf";
    public static final String ICON_FA_FILE_PLUS = "file-plus";
    public static final String ICON_FA_FILE_POWERPOINT = "file-powerpoint";
    public static final String ICON_FA_FILE_TIMES = "file-times";
    public static final String ICON_FA_FILE_VIDEO = "file-video";
    public static final String ICON_FA_FILE_WORD = "file-word";
    public static final String ICON_FA_FILM = "film";
    public static final String ICON_FA_FILM_ALT = "film-alt";
    public static final String ICON_FA_FILTER = "filter";
    public static final String ICON_FA_FINGERPRINT = "fingerprint";
    public static final String ICON_FA_FIRE = "fire";
    public static final String ICON_FA_FIRE_EXTINGUISHER = "fire-extinguisher";
    public static final String ICON_FA_FLAG = "flag";
    public static final String ICON_FA_FLAG_CHECKERED = "flag-checkered";
    public static final String ICON_FA_FLASK = "flask";
    public static final String ICON_FA_FOLDER = "folder";
    public static final String ICON_FA_FOLDER_OPEN = "folder-open";
    public static final String ICON_FA_FONT = "font";
    public static final String ICON_FA_FORWARD = "forward";
    public static final String ICON_FA_FROWN = "frown";
    public static final String ICON_FA_FUTBOL = "futbol";
    public static final String ICON_FA_GAMEPAD = "gamepad";
    public static final String ICON_FA_GAVEL = "gavel";
    public static final String ICON_FA_GEM = "gem";
    public static final String ICON_FA_GENDERLESS = "genderless";
    public static final String ICON_FA_GIFT = "gift";
    public static final String ICON_FA_GLASS_MARTINI = "glass-martini";
    public static final String ICON_FA_GLOBE = "globe";
    public static final String ICON_FA_GRADUATION_CAP = "graduation-cap";
    public static final String ICON_FA_H_SQUARE = "h-square";
    public static final String ICON_FA_H1 = "h1";
    public static final String ICON_FA_H2 = "h2";
    public static final String ICON_FA_H3 = "h3";
    public static final String ICON_FA_HAND_LIZARD = "hand-lizard";
    public static final String ICON_FA_HAND_PAPER = "hand-paper";
    public static final String ICON_FA_HAND_PEACE = "hand-peace";
    public static final String ICON_FA_HAND_POINT_DOWN = "hand-point-down";
    public static final String ICON_FA_HAND_POINT_LEFT = "hand-point-left";
    public static final String ICON_FA_HAND_POINT_RIGHT = "hand-point-right";
    public static final String ICON_FA_HAND_POINT_UP = "hand-point-up";
    public static final String ICON_FA_HAND_POINTER = "hand-pointer";
    public static final String ICON_FA_HAND_ROCK = "hand-rock";
    public static final String ICON_FA_HAND_SCISSORS = "hand-scissors";
    public static final String ICON_FA_HAND_SPOCK = "hand-spock";
    public static final String ICON_FA_HANDSHAKE = "handshake";
    public static final String ICON_FA_HASHTAG = "hashtag";
    public static final String ICON_FA_HDD = "hdd";
    public static final String ICON_FA_HEADING = "heading";
    public static final String ICON_FA_HEADPHONES = "headphones";
    public static final String ICON_FA_HEART = "heart";
    public static final String ICON_FA_HEARTBEAT = "heartbeat";
    public static final String ICON_FA_HEXAGON = "hexagon";
    public static final String ICON_FA_HISTORY = "history";
    public static final String ICON_FA_HOME = "home";
    public static final String ICON_FA_HOSPITAL = "hospital";
    public static final String ICON_FA_HOURGLASS = "hourglass";
    public static final String ICON_FA_HOURGLASS_END = "hourglass-end";
    public static final String ICON_FA_HOURGLASS_HALF = "hourglass-half";
    public static final String ICON_FA_HOURGLASS_START = "hourglass-start";
    public static final String ICON_FA_I_CURSOR = "i-cursor";
    public static final String ICON_FA_ID_BADGE = "id-badge";
    public static final String ICON_FA_ID_CARD = "id-card";
    public static final String ICON_FA_IMAGE = "image";
    public static final String ICON_FA_IMAGES = "images";
    public static final String ICON_FA_INBOX = "inbox";
    public static final String ICON_FA_INBOX_IN = "inbox-in";
    public static final String ICON_FA_INBOX_OUT = "inbox-out";
    public static final String ICON_FA_INDENT = "indent";
    public static final String ICON_FA_INDUSTRY = "industry";
    public static final String ICON_FA_INDUSTRY_ALT = "industry-alt";
    public static final String ICON_FA_INFO = "info";
    public static final String ICON_FA_INFO_CIRCLE = "info-circle";
    public static final String ICON_FA_INFO_SQUARE = "info-square";
    public static final String ICON_FA_ITALIC = "italic";
    public static final String ICON_FA_JACK_O_LANTERN = "jack-o-lantern";
    public static final String ICON_FA_KEY = "key";
    public static final String ICON_FA_KEYBOARD = "keyboard";
    public static final String ICON_FA_LANGUAGE = "language";
    public static final String ICON_FA_LAPTOP = "laptop";
    public static final String ICON_FA_LEAF = "leaf";
    public static final String ICON_FA_LEMON = "lemon";
    public static final String ICON_FA_LEVEL_DOWN = "level-down";
    public static final String ICON_FA_LEVEL_DOWN_ALT = "level-down-alt";
    public static final String ICON_FA_LEVEL_UP = "level-up";
    public static final String ICON_FA_LEVEL_UP_ALT = "level-up-alt";
    public static final String ICON_FA_LIFE_RING = "life-ring";
    public static final String ICON_FA_LIGHTBULB = "lightbulb";
    public static final String ICON_FA_LINK = "link";
    public static final String ICON_FA_LIRA_SIGN = "lira-sign";
    public static final String ICON_FA_LIST = "list";
    public static final String ICON_FA_LIST_ALT = "list-alt";
    public static final String ICON_FA_LIST_OL = "list-ol";
    public static final String ICON_FA_LIST_UL = "list-ul";
    public static final String ICON_FA_LOCATION = "location";
    public static final String ICON_FA_LOCATION_ARROW = "location-arrow";
    public static final String ICON_FA_LOCK = "lock";
    public static final String ICON_FA_LOCK_ALT = "lock-alt";
    public static final String ICON_FA_LOCK_OPEN = "lock-open";
    public static final String ICON_FA_LOCK_OPEN_ALT = "lock-open-alt";
    public static final String ICON_FA_LONG_ARROW_ALT_DOWN = "long-arrow-alt-down";
    public static final String ICON_FA_LONG_ARROW_ALT_LEFT = "long-arrow-alt-left";
    public static final String ICON_FA_LONG_ARROW_ALT_RIGHT = "long-arrow-alt-right";
    public static final String ICON_FA_LONG_ARROW_ALT_UP = "long-arrow-alt-up";
    public static final String ICON_FA_LONG_ARROW_DOWN = "long-arrow-down";
    public static final String ICON_FA_LONG_ARROW_LEFT = "long-arrow-left";
    public static final String ICON_FA_LONG_ARROW_RIGHT = "long-arrow-right";
    public static final String ICON_FA_LONG_ARROW_UP = "long-arrow-up";
    public static final String ICON_FA_LOW_VISION = "low-vision";
    public static final String ICON_FA_MAGIC = "magic";
    public static final String ICON_FA_MAGNET = "magnet";
    public static final String ICON_FA_MALE = "male";
    public static final String ICON_FA_MAP = "map";
    public static final String ICON_FA_MAP_MARKER = "map-marker";
    public static final String ICON_FA_MAP_MARKER_ALT = "map-marker-alt";
    public static final String ICON_FA_MAP_PIN = "map-pin";
    public static final String ICON_FA_MAP_SIGNS = "map-signs";
    public static final String ICON_FA_MARS = "mars";
    public static final String ICON_FA_MARS_DOUBLE = "mars-double";
    public static final String ICON_FA_MARS_STROKE = "mars-stroke";
    public static final String ICON_FA_MARS_STROKE_H = "mars-stroke-h";
    public static final String ICON_FA_MARS_STROKE_V = "mars-stroke-v";
    public static final String ICON_FA_MEDKIT = "medkit";
    public static final String ICON_FA_MEH = "meh";
    public static final String ICON_FA_MERCURY = "mercury";
    public static final String ICON_FA_MICROCHIP = "microchip";
    public static final String ICON_FA_MICROPHONE = "microphone";
    public static final String ICON_FA_MICROPHONE_ALT = "microphone-alt";
    public static final String ICON_FA_MICROPHONE_SLASH = "microphone-slash";
    public static final String ICON_FA_MINUS = "minus";
    public static final String ICON_FA_MINUS_CIRCLE = "minus-circle";
    public static final String ICON_FA_MINUS_HEXAGON = "minus-hexagon";
    public static final String ICON_FA_MINUS_OCTAGON = "minus-octagon";
    public static final String ICON_FA_MINUS_SQUARE = "minus-square";
    public static final String ICON_FA_MOBILE = "mobile";
    public static final String ICON_FA_MOBILE_ALT = "mobile-alt";
    public static final String ICON_FA_MOBILE_ANDROID = "mobile-android";
    public static final String ICON_FA_MOBILE_ANDROID_ALT = "mobile-android-alt";
    public static final String ICON_FA_MONEY_BILL = "money-bill";
    public static final String ICON_FA_MONEY_BILL_ALT = "money-bill-alt";
    public static final String ICON_FA_MOON = "moon";
    public static final String ICON_FA_MOTORCYCLE = "motorcycle";
    public static final String ICON_FA_MOUSE_POINTER = "mouse-pointer";
    public static final String ICON_FA_MUSIC = "music";
    public static final String ICON_FA_NEUTER = "neuter";
    public static final String ICON_FA_NEWSPAPER = "newspaper";
    public static final String ICON_FA_OBJECT_GROUP = "object-group";
    public static final String ICON_FA_OBJECT_UNGROUP = "object-ungroup";
    public static final String ICON_FA_OCTAGON = "octagon";
    public static final String ICON_FA_OUTDENT = "outdent";
    public static final String ICON_FA_PAINT_BRUSH = "paint-brush";
    public static final String ICON_FA_PAPER_PLANE = "paper-plane";
    public static final String ICON_FA_PAPERCLIP = "paperclip";
    public static final String ICON_FA_PARAGRAPH = "paragraph";
    public static final String ICON_FA_PASTE = "paste";
    public static final String ICON_FA_PAUSE = "pause";
    public static final String ICON_FA_PAUSE_CIRCLE = "pause-circle";
    public static final String ICON_FA_PAW = "paw";
    public static final String ICON_FA_PEN = "pen";
    public static final String ICON_FA_PEN_ALT = "pen-alt";
    public static final String ICON_FA_PEN_SQUARE = "pen-square";
    public static final String ICON_FA_PENCIL = "pencil";
    public static final String ICON_FA_PENCIL_ALT = "pencil-alt";
    public static final String ICON_FA_PERCENT = "percent";
    public static final String ICON_FA_PHONE = "phone";
    public static final String ICON_FA_PHONE_SLASH = "phone-slash";
    public static final String ICON_FA_PHONE_SQUARE = "phone-square";
    public static final String ICON_FA_PHONE_VOLUME = "phone-volume";
    public static final String ICON_FA_PLANE = "plane";
    public static final String ICON_FA_PLANE_ALT = "plane-alt";
    public static final String ICON_FA_PLAY = "play";
    public static final String ICON_FA_PLAY_CIRCLE = "play-circle";
    public static final String ICON_FA_PLUG = "plug";
    public static final String ICON_FA_PLUS = "plus";
    public static final String ICON_FA_PLUS_CIRCLE = "plus-circle";
    public static final String ICON_FA_PLUS_HEXAGON = "plus-hexagon";
    public static final String ICON_FA_PLUS_OCTAGON = "plus-octagon";
    public static final String ICON_FA_PLUS_SQUARE = "plus-square";
    public static final String ICON_FA_PODCAST = "podcast";
    public static final String ICON_FA_POO = "poo";
    public static final String ICON_FA_POLL = "poll";
    public static final String ICON_FA_PORTRAIT = "portrait";
    public static final String ICON_FA_POUND_SIGN = "pound-sign";
    public static final String ICON_FA_POWER_OFF = "power-off";
    public static final String ICON_FA_PRINT = "print";
    public static final String ICON_FA_PUZZLE_PIECE = "puzzle-piece";
    public static final String ICON_FA_QRCODE = "qrcode";
    public static final String ICON_FA_QUESTION = "question";
    public static final String ICON_FA_QUESTION_CIRCLE = "question-circle";
    public static final String ICON_FA_QUESTION_SQUARE = "question-square";
    public static final String ICON_FA_QUOTE_LEFT = "quote-left";
    public static final String ICON_FA_QUOTE_RIGHT = "quote-right";
    public static final String ICON_FA_RANDOM = "random";
    public static final String ICON_FA_RECTANGLE_LANDSCAPE = "rectangle-landscape";
    public static final String ICON_FA_RECTANGLE_PORTRAIT = "rectangle-portrait";
    public static final String ICON_FA_RECTANGLE_WIDE = "rectangle-wide";
    public static final String ICON_FA_RECYCLE = "recycle";
    public static final String ICON_FA_REDO = "redo";
    public static final String ICON_FA_REDO_ALT = "redo-alt";
    public static final String ICON_FA_REGISTERED = "registered";
    public static final String ICON_FA_REPEAT = "repeat";
    public static final String ICON_FA_REPEAT_1 = "repeat-1";
    public static final String ICON_FA_REPEAT_1_ALT = "repeat-1-alt";
    public static final String ICON_FA_REPEAT_ALT = "repeat-alt";
    public static final String ICON_FA_REPLY = "reply";
    public static final String ICON_FA_REPLY_ALL = "reply-all";
    public static final String ICON_FA_RETWEET = "retweet";
    public static final String ICON_FA_RETWEET_ALT = "retweet-alt";
    public static final String ICON_FA_ROAD = "road";
    public static final String ICON_FA_ROCKET = "rocket";
    public static final String ICON_FA_RSS = "rss";
    public static final String ICON_FA_RSS_SQUARE = "rss-square";
    public static final String ICON_FA_RUBLE_SIGN = "ruble-sign";
    public static final String ICON_FA_RUPEE_SIGN = "rupee-sign";
    public static final String ICON_FA_SAVE = "save";
    public static final String ICON_FA_SCRUBBER = "scrubber";
    public static final String ICON_FA_SEARCH = "search";
    public static final String ICON_FA_SEARCH_MINUS = "search-minus";
    public static final String ICON_FA_SEARCH_PLUS = "search-plus";
    public static final String ICON_FA_SERVER = "server";
    public static final String ICON_FA_SHARE = "share";
    public static final String ICON_FA_SHARE_ALL = "share-all";
    public static final String ICON_FA_SHARE_ALT = "share-alt";
    public static final String ICON_FA_SHARE_ALT_SQUARE = "share-alt-square";
    public static final String ICON_FA_SHARE_SQUARE = "share-square";
    public static final String ICON_FA_SHEKEL_SIGN = "shekel-sign";
    public static final String ICON_FA_SHIELD = "shield";
    public static final String ICON_FA_SHIELD_ALT = "shield-alt";
    public static final String ICON_FA_SHIELD_CHECK = "shield-check";
    public static final String ICON_FA_SHIP = "ship";
    public static final String ICON_FA_SHOPPING_BAG = "shopping-bag";
    public static final String ICON_FA_SHOPPING_BASKET = "shopping-basket";
    public static final String ICON_FA_SHOPPING_CART = "shopping-cart";
    public static final String ICON_FA_SHOWER = "shower";
    public static final String ICON_FA_SIGN_IN = "sign-in";
    public static final String ICON_FA_SIGN_IN_ALT = "sign-in-alt";
    public static final String ICON_FA_SIGN_LANGUAGE = "sign-language";
    public static final String ICON_FA_SIGN_OUT = "sign-out";
    public static final String ICON_FA_SIGN_OUT_ALT = "sign-out-alt";
    public static final String ICON_FA_SIGNAL = "signal";
    public static final String ICON_FA_SIGNAL_1 = "signal-1";
    public static final String ICON_FA_SIGNAL_2 = "signal-2";
    public static final String ICON_FA_SIGNAL_3 = "signal-3";
    public static final String ICON_FA_SIGNAL_4 = "signal-4";

    public static final String ICON_FA_SIGNAL_SLASH = "signal-slash";
    public static final String ICON_FA_SITEMAP = "sitemap";
    public static final String ICON_FA_SLIDERS_H = "sliders-h";
    public static final String ICON_FA_SLIDERS_H_SQUARE = "sliders-h-square";
    public static final String ICON_FA_SLIDERS_V = "sliders-v";
    public static final String ICON_FA_SLIDERS_V_SQUARE = "sliders-v-square";
    public static final String ICON_FA_SMILE = "smile";
    public static final String ICON_FA_SNOWFLAKE = "snowflake";
    public static final String ICON_FA_SORT = "sort";
    public static final String ICON_FA_SORT_ALPHA_DOWN = "sort-alpha-down";
    public static final String ICON_FA_SORT_ALPHA_UP = "sort-alpha-up";
    public static final String ICON_FA_SORT_AMOUNT_DOWN = "sort-amount-down";
    public static final String ICON_FA_SORT_AMOUNT_UP = "sort-amount-up";
    public static final String ICON_FA_SORT_DOWN = "sort-down";
    public static final String ICON_FA_SORT_NUMERIC_DOWN = "sort-numeric-down";
    public static final String ICON_FA_SORT_NUMERIC_UP = "sort-numeric-up";
    public static final String ICON_FA_SORT_UP = "sort-up";
    public static final String ICON_FA_SPACE_SHUTTLE = "space-shuttle";
    public static final String ICON_FA_SPADE = "spade";
    public static final String ICON_FA_SPINNER = "spinner";
    public static final String ICON_FA_SPINNER_THIRD = "spinner-third";
    public static final String ICON_FA_SQUARE = "square";
    public static final String ICON_FA_STAR = "star";
    public static final String ICON_FA_STAR_EXCLAMATION = "star-exclamation";
    public static final String ICON_FA_STAR_HALF = "star-half";
    public static final String ICON_FA_STEP_BACKWARD = "step-backward";
    public static final String ICON_FA_STEP_FORWARD = "step-forward";
    public static final String ICON_FA_STETHOSCOPE = "stethoscope";
    public static final String ICON_FA_STICKY_NOTE = "sticky-note";
    public static final String ICON_FA_STOP = "stop";
    public static final String ICON_FA_STOP_CIRCLE = "stop-circle";
    public static final String ICON_FA_STOPWATCH = "stopwatch";
    public static final String ICON_FA_STREET_VIEW = "street-view";
    public static final String ICON_FA_STRIKETHROUGH = "strikethrough";
    public static final String ICON_FA_SUBSCRIPT = "subscript";
    public static final String ICON_FA_SUBWAY = "subway";
    public static final String ICON_FA_SUITCASE = "suitcase";
    public static final String ICON_FA_SUN = "sun";
    public static final String ICON_FA_SUPERSCRIPT = "superscript";
    public static final String ICON_FA_SYNC = "sync";
    public static final String ICON_FA_SYNC_ALT = "sync-alt";
    public static final String ICON_FA_TABLE = "table";
    public static final String ICON_FA_TABLET = "tablet";
    public static final String ICON_FA_TABLET_ALT = "tablet-alt";
    public static final String ICON_FA_TABLET_ANDROID = "tablet-android";
    public static final String ICON_FA_TABLET_ANDROID_ALT = "tablet-android-alt";
    public static final String ICON_FA_TACHOMETER = "tachometer";
    public static final String ICON_FA_TACHOMETER_ALT = "tachometer-alt";
    public static final String ICON_FA_TAG = "tag";
    public static final String ICON_FA_TAGS = "tags";
    public static final String ICON_FA_TASKS = "tasks";
    public static final String ICON_FA_TAXI = "taxi";
    public static final String ICON_FA_TERMINAL = "terminal";
    public static final String ICON_FA_TEXT_HEIGHT = "text-height";
    public static final String ICON_FA_TEXT_WIDTH = "text-width";
    public static final String ICON_FA_TH = "th";
    public static final String ICON_FA_TH_LARGE = "th-large";
    public static final String ICON_FA_TH_LIST = "th-list";
    public static final String ICON_FA_THERMOMETER_EMPTY = "thermometer-empty";
    public static final String ICON_FA_THERMOMETER_FULL = "thermometer-full";
    public static final String ICON_FA_THERMOMETER_HALF = "thermometer-half";
    public static final String ICON_FA_THERMOMETER_QUARTER = "thermometer-quarter";
    public static final String ICON_FA_THERMOMETER_THREE_QUARTERS = "thermometer-three-quarters";
    public static final String ICON_FA_THUMBS_DOWN = "thumbs-down";
    public static final String ICON_FA_THUMBS_UP = "thumbs-up";
    public static final String ICON_FA_THUMBTACK = "thumbtack";
    public static final String ICON_FA_TICKET = "ticket";
    public static final String ICON_FA_TICKET_ALT = "ticket-alt";
    public static final String ICON_FA_TIMES = "times";
    public static final String ICON_FA_TIMES_CIRCLE = "times-circle";
    public static final String ICON_FA_TIMES_HEXAGON = "times-hexagon";
    public static final String ICON_FA_TIMES_OCTAGON = "times-octagon";
    public static final String ICON_FA_TIMES_SQUARE = "times-square";
    public static final String ICON_FA_TINT = "tint";
    public static final String ICON_FA_TOGGLE_OFF = "toggle-off";
    public static final String ICON_FA_TOGGLE_ON = "toggle-on";
    public static final String ICON_FA_TRADEMARK = "trademark";
    public static final String ICON_FA_TRAIN = "train";
    public static final String ICON_FA_TRANSGENDER = "transgender";
    public static final String ICON_FA_TRANSGENDER_ALT = "transgender-alt";
    public static final String ICON_FA_TRASH = "trash";
    public static final String ICON_FA_TRASH_ALT = "trash-alt";
    public static final String ICON_FA_TREE = "tree";
    public static final String ICON_FA_TREE_ALT = "tree-alt";
    public static final String ICON_FA_TRIANGLE = "triangle";
    public static final String ICON_FA_TROPHY = "trophy";
    public static final String ICON_FA_TROPHY_ALT = "trophy-alt";
    public static final String ICON_FA_TRUCK = "truck";
    public static final String ICON_FA_TTY = "tty";
    public static final String ICON_FA_TV = "tv";
    public static final String ICON_FA_TV_RETRO = "tv-retro";
    public static final String ICON_FA_UMBRELLA = "umbrella";
    public static final String ICON_FA_UNDERLINE = "underline";
    public static final String ICON_FA_UNDO = "undo";
    public static final String ICON_FA_UNDO_ALT = "undo-alt";
    public static final String ICON_FA_UNIVERSAL_ACCESS = "universal-access";
    public static final String ICON_FA_UNIVERSITY = "university";
    public static final String ICON_FA_UNLINK = "unlink";
    public static final String ICON_FA_UNLOCK = "unlock";
    public static final String ICON_FA_UNLOCK_ALT = "unlock-alt";
    public static final String ICON_FA_UPLOAD = "upload";
    public static final String ICON_FA_USD_CIRCLE = "usd-circle";
    public static final String ICON_FA_USD_SQUARE = "usd-square";
    public static final String ICON_FA_USER = "user";
    public static final String ICON_FA_USER_ALT = "user-alt";
    public static final String ICON_FA_USER_CIRCLE = "user-circle";
    public static final String ICON_FA_USER_MD = "user-md";
    public static final String ICON_FA_USER_PLUS = "user-plus";
    public static final String ICON_FA_USER_SECRET = "user-secret";
    public static final String ICON_FA_USER_TIMES = "user-times";
    public static final String ICON_FA_USERS = "users";
    public static final String ICON_FA_UTENSIL_FORK = "utensil-fork";
    public static final String ICON_FA_UTENSIL_KNIFE = "utensil-knife";
    public static final String ICON_FA_UTENSIL_SPOON = "utensil-spoon";
    public static final String ICON_FA_UTENSILS = "utensils";
    public static final String ICON_FA_UTENSILS_ALT = "utensils-alt";
    public static final String ICON_FA_VENUS = "venus";
    public static final String ICON_FA_VENUS_DOUBLE = "venus-double";
    public static final String ICON_FA_VENUS_MARS = "venus-mars";
    public static final String ICON_FA_VIDEO = "video";
    public static final String ICON_FA_VOLUME_DOWN = "volume-down";
    public static final String ICON_FA_VOLUME_MUTE = "volume-mute";
    public static final String ICON_FA_VOLUME_OFF = "volume-off";
    public static final String ICON_FA_VOLUME_UP = "volume-up";
    public static final String ICON_FA_WATCH = "watch";
    public static final String ICON_FA_WHEELCHAIR = "wheelchair";
    public static final String ICON_FA_WIFI = "wifi";
    public static final String ICON_FA_WIFI_1 = "wifi-1";
    public static final String ICON_FA_WIFI_2 = "wifi-2";
    public static final String ICON_FA_WIFI_SLASH = "wifi-slash";
    public static final String ICON_GATEWAY = "gateway";
    public static final String ICON_FA_WINDOW = "window";
    public static final String ICON_FA_WINDOW_ALT = "window-alt";
    public static final String ICON_FA_WINDOW_CLOSE = "window-close";
    public static final String ICON_FA_WINDOW_MAXIMIZE = "window-maximize";
    public static final String ICON_FA_WINDOW_MINIMIZE = "window-minimize";
    public static final String ICON_FA_WINDOW_RESTORE = "window-restore";
    public static final String ICON_FA_WON_SIGN = "won-sign";
    public static final String ICON_FA_WRENCH = "wrench";
    public static final String ICON_FA_YEN_SIGN = "yen-sign";
    public static final String ICON_FA_EMERGENCY = "emergency";
    public static final String ICON_FA_METER = "meter";
    public static final String ICON_FA_USER_HEADSET = "user-headset";
    public static final String ICON_FA_PAGER="pager";

    public static final int PPFontIconTypeNone = -1;
    public static final int PPFontIconTypePP = 0;
    public static final int PPFontIconTypePPLight = 1;
    public static final int PPFontIconTypeWeather = 10;
    public static final int PPFontIconTypeWeatherLight = 11;
    public static final int PPFontIconTypeFA = 20;
    public static final int PPFontIconTypeFALight = 21;
    public static final int PPFontIconTypeFASolid = 22;
    public static final int PPFontIconTypeFABrands = 23;

    public static final int PPDeviceTypeNone = -1;

    public static final String filePathForPPCIcon = "font/glyphs/ppcioticonglyphs.json";
    public static final String filePathForFontAwesome = "font/glyphs/fontawesomeglyphs.json";
    public static final String filePathForFontAwesomeBrands = "font/glyphs/fontawesomebrands.json";
    public static final String filePathForWeatherIcon = "font/glyphs/weathericonglyphs.json";
    public static final String mappingjson = "font/glyphs/mapping.json";

    public static final String fontAwesomeBrand = "font/fa_brands_400.ttf";
    public static final String fontAwesomeLight = "font/fa_light_300.ttf";
    public static final String fontAwesomeRegular = "font/fa_regular_400.ttf";
    public static final String fontAwesomeSolid = "font/fa_solid_900.ttf";
    public static final String ppcIotIconsLight = "font/PPCIOTIconsLight.ttf";
    public static final String ppcIotIconsRegular = "font/PPCIOTIconsRegular.ttf";
    public static final String weatherIconsLight = "font/WeatherIconsLight.ttf";
    public static final String weatherIconsRegular = "font/WeatherIconsRegular.ttf";

    public static final String fontAwesomeBoldType = "fab";
    public static final String fontAwesomeLightType = "fal";
    public static final String fontAwesomeRegularType = "far";
    public static final String fontAwesomeSolidType = "fas";
    public static final String PPCLightType = "iotl";
    public static final String PPCRegularType = "iotr";
    public static final String WeatherLightType = "wil";
    public static final String WeatherRegularType = "wir";


    private JSONObject PPCIconJsonData = null;
    private JSONObject WeatherIconJsonData = null;
    private JSONObject fontAwesomeJsonData = null;
    private JSONObject fontAwesomeBrandsJsonData = null;
    private static JSONObject mappingJsonData = null;

    private Typeface PPCIconTypeface = null;
    private Typeface PPCLightIconTypeface = null;
    private Typeface WeatherIconTypeface = null;
    private Typeface WeatherLightIconTypeface = null;
    private Typeface fontAwesomeTypeface = null;
    private Typeface fontAwesomeLightTypeface = null;
    private Typeface fontAwesomeSolidTypeface = null;
    private Typeface fontAwesomeBrandsTypeface = null;


    public PPFontIconLabel(Context context) {
        mContext = context;
        PPCIconJsonData = getJsonDataFromFile(filePathForPPCIcon);
        WeatherIconJsonData = getJsonDataFromFile(filePathForWeatherIcon);
        fontAwesomeJsonData = getJsonDataFromFile(filePathForFontAwesome);
        fontAwesomeBrandsJsonData = getJsonDataFromFile(filePathForFontAwesomeBrands);
        mappingJsonData = getJsonDataFromFile(mappingjson);

        PPCIconTypeface = Typeface.createFromAsset(mContext.getAssets(), ppcIotIconsRegular);
        PPCLightIconTypeface = Typeface.createFromAsset(mContext.getAssets(), ppcIotIconsLight);
        WeatherIconTypeface = Typeface.createFromAsset(mContext.getAssets(), weatherIconsRegular);
        WeatherLightIconTypeface = Typeface.createFromAsset(mContext.getAssets(), weatherIconsLight);
        fontAwesomeTypeface = Typeface.createFromAsset(mContext.getAssets(), fontAwesomeRegular);
        fontAwesomeLightTypeface = Typeface.createFromAsset(mContext.getAssets(), fontAwesomeLight);
        fontAwesomeSolidTypeface = Typeface.createFromAsset(mContext.getAssets(), fontAwesomeSolid);
        fontAwesomeBrandsTypeface = Typeface.createFromAsset(mContext.getAssets(), fontAwesomeBrand);
    }

    public String unicodeStringForIconNameByType(String iconName, int type) {
        String unicodeString = iconName;
        int fontIconType = fontTypeForIconNameByType(iconName, type);
        switch (fontIconType) {
            case PPFontIconTypePP:
            case PPFontIconTypePPLight:
                unicodeString = getUnicode(PPCIconJsonData, iconName, type);
                break;
            case PPFontIconTypeWeather:
            case PPFontIconTypeWeatherLight:
                unicodeString = getUnicode(WeatherIconJsonData, iconName, type);
                break;
            case PPFontIconTypeFA:
            case PPFontIconTypeFALight:
            case PPFontIconTypeFASolid:
                unicodeString = getUnicode(fontAwesomeJsonData, iconName, type);
                break;
            case PPFontIconTypeFABrands:
                unicodeString = getUnicode(fontAwesomeBrandsJsonData, iconName, type);
                break;
            default:
                unicodeString = getUnicode(PPCIconJsonData, iconName, type);
                break;
        }

        PPVirtuosoLogTrace.d(TAG, "ICON CODE = " + unicodeString);

        return unicodeString;
    }

    public String unicodeStringForIconNameByTypePPHighPriority(String iconName, int type) {
        String unicodeString = iconName;
        int fontIconType = fontTypeForIconNameByTypePPHighPriority(iconName, type);
        switch (fontIconType) {
            case PPFontIconTypePP:
            case PPFontIconTypePPLight:
                unicodeString = getUnicode(PPCIconJsonData, iconName, type);
                break;
            case PPFontIconTypeWeather:
            case PPFontIconTypeWeatherLight:
                unicodeString = getUnicode(WeatherIconJsonData, iconName, type);
                break;
            case PPFontIconTypeFA:
            case PPFontIconTypeFALight:
            case PPFontIconTypeFASolid:
                unicodeString = getUnicode(fontAwesomeJsonData, iconName, type);
                break;
            case PPFontIconTypeFABrands:
                unicodeString = getUnicode(fontAwesomeBrandsJsonData, iconName, type);
                break;
            default:
                unicodeString = getUnicode(PPCIconJsonData, iconName, type);
                break;
        }

        PPVirtuosoLogTrace.d(TAG, "ICON CODE = " + unicodeString);

        return unicodeString;
    }

    public String getUnicode(JSONObject JsonData, String iconName, int type) {

        String unicodeString = iconName;
        if (JsonData != null) {
            try {
                String iconCode = JsonData.has(iconName) ? JsonData.getString(iconName) : null;
                if (iconCode == null) {
                    iconName = findDeviceIconNameByType(type);
                    iconCode = JsonData.has(iconName) ? JsonData.getString(iconName) : null;
                }
                unicodeString = iconCode;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return unicodeString;
    }


    public String unicodeStringForIconNameByFontIconType(String iconName, int type, int fontIconType) {
        String unicodeString = iconName;
        JSONObject JsonData = null;
        switch (fontIconType) {
            case PPFontIconTypePP:
            case PPFontIconTypePPLight:
                unicodeString = getUnicode(PPCIconJsonData, iconName, fontIconType);
                break;
            case PPFontIconTypeWeather:
            case PPFontIconTypeWeatherLight:
                unicodeString = getUnicode(WeatherIconJsonData, iconName, fontIconType);
                break;
            case PPFontIconTypeFA:
            case PPFontIconTypeFALight:
            case PPFontIconTypeFASolid:
                unicodeString = getUnicode(fontAwesomeJsonData, iconName, fontIconType);
                break;
            case PPFontIconTypeFABrands:
                unicodeString = getUnicode(fontAwesomeBrandsJsonData, iconName, fontIconType);
                break;
            default:
                unicodeString = getUnicode(PPCIconJsonData, iconName, fontIconType);
                break;
        }
        if (JsonData != null) {
            try {
                String iconCode = JsonData.has(iconName) ? JsonData.getString(iconName) : null;
                if (iconCode == null) {
                    iconName = findDeviceIconNameByType(type);
                    iconCode = JsonData.has(iconName) ? JsonData.getString(iconName) : null;
                }
                unicodeString = iconCode;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
//        PPVirtuosoLogTrace.d(TAG, "ICON CODE = " + unicodeString);

        return unicodeString;
    }


    public Typeface getTypeFaceByIconNameByType(String iconName, int type) {
        int fontIconType = fontTypeForIconNameByType(iconName, type);
        Typeface typeface = null;
        switch (fontIconType) {
            case PPFontIconTypePP:
            case PPFontIconTypePPLight:
                typeface = PPCIconTypeface;
                break;
            case PPFontIconTypeWeather:
            case PPFontIconTypeWeatherLight:
                typeface = WeatherIconTypeface;
                break;
            case PPFontIconTypeFABrands:
                typeface = fontAwesomeBrandsTypeface;
                break;
            case PPFontIconTypeFA:
            case PPFontIconTypeFALight:
            case PPFontIconTypeFASolid:
                typeface = fontAwesomeTypeface;
                break;
            default:

                break;
        }
        return typeface;
    }

    public Typeface getTypeFaceByName(String type) {
        Typeface typeface = null;
        if (!TextUtils.isEmpty(type)) {
            if (type.equals(PPCRegularType)) {
                typeface = PPCIconTypeface;
            } else if (type.equals(PPCLightType)) {
                typeface = PPCLightIconTypeface;
            } else if (type.equals(WeatherRegularType)) {
                typeface = WeatherIconTypeface;
            } else if (type.equals(WeatherLightType)) {
                typeface = WeatherLightIconTypeface;
            } else if (type.equals(fontAwesomeBoldType)) {
                typeface = fontAwesomeBrandsTypeface;
            } else if (type.equals(fontAwesomeRegularType)) {
                typeface = fontAwesomeTypeface;
            } else if (type.equals(fontAwesomeLightType)) {
                typeface = fontAwesomeLightTypeface;
            } else if (type.equals(fontAwesomeSolidType)) {
                typeface = fontAwesomeSolidTypeface;
            }
        }
        return typeface;
    }

    public int getTypeFaceTypeByName(String type) {
        int iType = -1;
        if (!TextUtils.isEmpty(type)) {
            if (type.equals(PPCRegularType)) {
                iType = PPFontIconTypePP;
            } else if (type.equals(PPCLightType)) {
                iType = PPFontIconTypePPLight;
            } else if (type.equals(WeatherRegularType)) {
                iType = PPFontIconTypeWeather;
            } else if (type.equals(WeatherLightType)) {
                iType = PPFontIconTypeWeatherLight;
            } else if (type.equals(fontAwesomeBoldType)) {
                iType = PPFontIconTypeFABrands;
            } else if (type.equals(fontAwesomeRegularType)) {
                iType = PPFontIconTypeFA;
            } else if (type.equals(fontAwesomeLightType)) {
                iType = PPFontIconTypeFALight;
            } else if (type.equals(fontAwesomeSolidType)) {
                iType = PPFontIconTypeFASolid;
            } else {
                iType = PPFontIconTypeNone;
            }
        }
        return iType;
    }

    public Typeface getTypeFaceByIconNameBySolidType(String iconName, int type) {
        int fontIconType = fontTypeForIconNameByType(iconName, type);
        Typeface typeface = null;
        switch (fontIconType) {
            case PPFontIconTypePP:
            case PPFontIconTypePPLight:
                typeface = PPCIconTypeface;
                break;
            case PPFontIconTypeWeather:
            case PPFontIconTypeWeatherLight:
                typeface = WeatherIconTypeface;
                break;
            case PPFontIconTypeFABrands:
                typeface = fontAwesomeBrandsTypeface;
                break;
            case PPFontIconTypeFA:
            case PPFontIconTypeFALight:
            case PPFontIconTypeFASolid:
                typeface = fontAwesomeSolidTypeface;
                break;
            default:

                break;
        }
        return typeface;
    }

    public Typeface getTypeFaceByIconNameByTypePPHighPriority(String iconName, int type) {
        int fontIconType = fontTypeForIconNameByTypePPHighPriority(iconName, type);
        Typeface typeface = null;
        switch (fontIconType) {
            case PPFontIconTypePP:
            case PPFontIconTypePPLight:
                typeface = PPCIconTypeface;
                break;
            case PPFontIconTypeFA:
            case PPFontIconTypeFALight:
            case PPFontIconTypeFASolid:
                typeface = fontAwesomeTypeface;
                break;
            case PPFontIconTypeFABrands:
                typeface = fontAwesomeBrandsTypeface;
                break;
            case PPFontIconTypeWeather:
            case PPFontIconTypeWeatherLight:
                typeface = WeatherIconTypeface;
                break;
            default:

                break;
        }
        return typeface;
    }


    public int fontTypeForIconNameByType(String iconName, int type) {
        int fontIconType = PPFontIconTypeNone;
        PPVirtuosoLogTrace.d(TAG, "Load asseet 1");
        try {
            JSONObject PPCIotJson = PPCIconJsonData;
            JSONObject awesomeFontJson = fontAwesomeJsonData;
            JSONObject awesomeFontBrandsJson = fontAwesomeBrandsJsonData;
            JSONObject weatherIconJson = WeatherIconJsonData;
            if (iconName == null) {
                iconName = findDeviceIconNameByType(type);
            }

            if (weatherIconJson.has(iconName)) {
                fontIconType = PPFontIconTypeWeather;
            } else if (awesomeFontJson.has(iconName)) {
                fontIconType = PPFontIconTypeFA;
            } else if (awesomeFontBrandsJson.has(iconName)) {
                fontIconType = PPFontIconTypeFABrands;
            } else if (PPCIotJson.has(iconName)) {
                fontIconType = PPFontIconTypePP;
            }

            if (fontIconType == PPFontIconTypeNone) {
                iconName = findDeviceIconNameByType(type);
                if (PPCIotJson.has(iconName)) {
                    fontIconType = PPFontIconTypePP;
                } else if (awesomeFontJson.has(iconName)) {
                    fontIconType = PPFontIconTypeFA;
                } else if (awesomeFontBrandsJson.has(iconName)) {
                    fontIconType = PPFontIconTypeFABrands;
                } else if (weatherIconJson.has(iconName)) {
                    fontIconType = PPFontIconTypeWeather;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        PPVirtuosoLogTrace.d(TAG, "FONT TYPE =  " + fontIconType);
        return fontIconType;
    }

    public int fontTypeForIconNameByTypePPHighPriority(String iconName, int type) {
        int fontIconType = PPFontIconTypeNone;
        PPVirtuosoLogTrace.d(TAG, "Load asseet 1");
        try {
            JSONObject PPCIotJson = PPCIconJsonData;
            JSONObject awesomeFontJson = fontAwesomeJsonData;
            JSONObject awesomeFontBrandsJson = fontAwesomeBrandsJsonData;
            JSONObject weatherIconJson = WeatherIconJsonData;
            if (iconName == null) {
                iconName = findDeviceIconNameByType(type);
            }

            if (PPCIotJson.has(iconName)) {
                fontIconType = PPFontIconTypePP;
            } else if (awesomeFontBrandsJson.has(iconName)) {
                fontIconType = PPFontIconTypeFABrands;
            } else if (awesomeFontJson.has(iconName)) {
                fontIconType = PPFontIconTypeFA;
            } else if (weatherIconJson.has(iconName)) {
                fontIconType = PPFontIconTypeWeather;
            }

            if (fontIconType == PPFontIconTypeNone) {
                iconName = findDeviceIconNameByType(type);
                if (PPCIotJson.has(iconName)) {
                    fontIconType = PPFontIconTypePP;
                } else if (awesomeFontJson.has(iconName)) {
                    fontIconType = PPFontIconTypeFA;
                } else if (awesomeFontBrandsJson.has(iconName)) {
                    fontIconType = PPFontIconTypeFABrands;
                } else if (weatherIconJson.has(iconName)) {
                    fontIconType = PPFontIconTypeWeather;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        PPVirtuosoLogTrace.d(TAG, "FONT TYPE =  " + fontIconType);
        return fontIconType;
    }


    public String loadJSONFromAsset(String path) {
        String json = null;
        try {
            InputStream is = mContext.getAssets().open(path);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public JSONObject getJsonDataFromFile(String path) {
        JSONObject JsonData = null;
        try {
            JsonData = new JSONObject(loadJSONFromAsset(path));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return JsonData;
    }

    public String findDeviceIconNameByType(int deviceType) {
        //Device type 26 looks IOS camera it could be changed later.
        if (deviceType == PPCommonInfo.INT_PRESENCE_IOS_CAMERA || deviceType == 26) {
            return ICON_CAMERA_IOS;
        } else if (deviceType == PPCommonInfo.INT_PRESENCE_ANDROID_CAMERA) {
            return ICON_CAMERA_ANDROID;
        } else if (deviceType >= PPCommonInfo.INT_TED_MTU_LOAD && deviceType <= PPCommonInfo.INT_TED_MTU) {
            return ICON_FA_TACHOMETER_ALT;
        } else if (deviceType == PPCommonInfo.INT_BLUE_LINE_POWERCOST_MONITOR) {
            return ICON_FA_TACHOMETER_ALT;
        } else if (deviceType == PPCommonInfo.INT_GREEN_GATEWAY || deviceType == PPCommonInfo.INT_PEOPLE_POWER_GATEWAY || deviceType == PPCommonInfo.INT_X5_GATEWAY
            || deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW101 || deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW211 || deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW221) {
            return ICON_GATEWAY;
        } else if (deviceType == PPCommonInfo.INT_DOOR_WINDOW_SENSOR || deviceType == PPCommonInfo.INT_DEVELCO_ENTRY_SENSOR) {
            return ICON_ENTRY;
        } else if (deviceType == PPCommonInfo.INT_MOTION_DETECTOR) {
            return ICON_MOTION;
        } else if (deviceType == PPCommonInfo.INT_TOUCH_SENSOR) {
            return ICON_TOUCH;
        } else if (deviceType == PPCommonInfo.INT_MOTION_SENSOR || deviceType == PPCommonInfo.INT_DEVELCO_MOTION_SENSOR) {
            return ICON_MOTION;
        } else if (deviceType == PPCommonInfo.INT_LEAK_DETECTOR || deviceType == PPCommonInfo.INT_DEVELCO_WATER_SENSOR) {
            return ICON_FA_TINT;
        } else if (deviceType == PPCommonInfo.INT_TEMPERATURE_SENSOR) {
            return ICON_FA_THERMOMETER_HALF;
        } else if (deviceType == PPCommonInfo.INT_HUMIDITY_SENSOR) {
            return ICON_TEMP_HUMIDITY;
        } else if (deviceType == PPCommonInfo.INT_HUMIDITY_TEMP_SENSOR
            || deviceType == PPCommonInfo.INT_HUMIDITY_TEMP_LIGHT_SENSOR) {
            return ICON_TEMP_HUMIDITY;
        } else if (deviceType == PPCommonInfo.INT_GE_LIGHT_BULB) {
            return ICON_FA_LIGHTBULB;
        } else if (deviceType == PPCommonInfo.INT_WIFI_SMART_PLUG) {
            return ICON_PLUG;
        } else if (deviceType == PPCommonInfo.INT_CENTRALITE_SMART_PLUG
            || deviceType == PPCommonInfo.INT_VISUAL_ENERGY_UFO_POWER_STRIP
            || deviceType == PPCommonInfo.INT_LOAD_CONTROLLER) {
            return ICON_PLUG;
        } else if (deviceType == PPCommonInfo.INT_LINT_ALERT_PRO_PLUS) {
            return ICON_DRYER;
        } else if (deviceType == PPCommonInfo.INT_THERMOSTAT
            || deviceType == PPCommonInfo.INT_HONEYWELL_LYRIC_THERMOSTAT
            || deviceType == PPCommonInfo.INT_ECOBEE_THERMOSTAT
            || deviceType == PPCommonInfo.INT_EMERSON_THERMOSTAT) {
            return ICON_THERMOSTAT;
        } else if (deviceType == PPCommonInfo.INT_FOSCAM_IP_CAMERA
            || deviceType == PPCommonInfo.INT_AMTK_IP_CAMERA
            || deviceType == PPCommonInfo.INT_NETATMO_WELCOME_CAMERA
            || deviceType == PPCommonInfo.INT_BAYCAM_IP_CAMERA
            || deviceType == PPCommonInfo.INT_PPC_IP_CAMERA
            || deviceType == PPCommonInfo.INT_ALFAPRO_IP_CAMERA) {
            return ICON_CAMERA_IP;
        } else if (deviceType == PPCommonInfo.INT_GALILEO_BLUETOOTH_40) {
            return ICON_CAMERA_GALILEO;
        } else if (deviceType == PPCommonInfo.INT_GREEN_BUTTON || deviceType == PPCommonInfo.INT_ENERGY_METER) {
            return ICON_FA_TACHOMETER_ALT;
        } else if (deviceType == PPCommonInfo.INT_QMOTE) {
            return ICON_FA_CROSSHAIRS;
        } else if (deviceType == PPCommonInfo.INT_IBEACON) {
            return ICON_GEOFENCING;
        } else if (deviceType == PPCommonInfo.INT_IN_WALL_SWITCH) {
            return ICON_SWITCH;
        } else if (deviceType == PPCommonInfo.INT_SIREN || deviceType == PPCommonInfo.INT_LH_SIREN || deviceType == PPCommonInfo.INT_DEVELCO_SIREN) {
            return ICON_FA_BULLHORN;
        } else if (deviceType == PPCommonInfo.INT_PRESENCE_360) {
            return ICON_360;
        } else if (deviceType == PPCommonInfo.INT_NETATMO_HEALTHY_HOME_COACH) {
            return ICON_AIR;
        } else if (deviceType == PPCommonInfo.INT_NETATMO_WEATHER_STATION_INDOOR
            || deviceType == PPCommonInfo.INT_NETATMO_WEATHER_STATION_OUTDOOR) {
            return ICON_WEATHER;
        } else if (deviceType == PPCommonInfo.INT_SENSIBO_THERMOSTAT) {
            return ICON_AC;
        } else if (deviceType == PPCommonInfo.INT_ANDROID_TOUCHPAD) {
            return ICON_TOUCHPAD;
        } else if (deviceType == PPCommonInfo.INT_DOOR_LOCK) {
            return ICON_SMART_LOCK;
        } else if (deviceType == PPCommonInfo.INT_CO2_DETECTOR) {
            return ICON_CO2_DETECTOR;
        } else if (deviceType == PPCommonInfo.INT_EWIG_BUTTON || deviceType == PPCommonInfo.INT_DEVELCO_BUTTON || deviceType == PPCommonInfo.INT_DEVELCO_MULITI_BUTTON) {
            return ICON_TOUCH;
        } else if (deviceType == PPCommonInfo.INT_PRESSURE_PAD_SENSOR) {
            return ICON_FA_BED;
        } else {
            return ICON_PRESENCE;
        }
    }

    public Typeface getTypeFaceByType(int type) {
        Typeface typeface = null;
        switch (type) {
            case PPFontIconTypePP:
            case PPFontIconTypePPLight:
                typeface = PPCIconTypeface;
                break;
            case PPFontIconTypeWeather:
            case PPFontIconTypeWeatherLight:
                typeface = WeatherIconTypeface;
                break;
            case PPFontIconTypeFA:
            case PPFontIconTypeFALight:
                typeface = fontAwesomeTypeface;
                break;
            case PPFontIconTypeFASolid:
                typeface = fontAwesomeSolidTypeface;
                break;
            case PPFontIconTypeFABrands:
                typeface = fontAwesomeBrandsTypeface;
                break;
            default:

                break;
        }
        return typeface;
    }

    public String unicodeStringForIconNameWithType(String iconName, int type) {
        String unicodeString = iconName;
        switch (type) {
            case PPFontIconTypePP:
            case PPFontIconTypePPLight:
                unicodeString = getUnicode(PPCIconJsonData, iconName, type);
                break;
            case PPFontIconTypeWeather:
            case PPFontIconTypeWeatherLight:
                unicodeString = getUnicode(WeatherIconJsonData, iconName, type);
                break;
            case PPFontIconTypeFA:
            case PPFontIconTypeFALight:
            case PPFontIconTypeFASolid:
                unicodeString = getUnicode(fontAwesomeJsonData, iconName, type);
                break;
            case PPFontIconTypeFABrands:
                unicodeString = getUnicode(fontAwesomeBrandsJsonData, iconName, type);
                break;
            default:
                unicodeString = getUnicode(PPCIconJsonData, iconName, type);
                break;
        }
//        PPVirtuosoLogTrace.d(TAG, "ICON CODE = " + unicodeString);

        return unicodeString;
    }

    public static String mappingFontName(String name) {
        String newName = null;
        JSONObject jsonObj = mappingJsonData;
        JSONObject jsonObjItem = null;
        JSONArray jsonArray = null;

        try {
            jsonArray = (jsonObj.getJSONArray("mapping"));
            if (jsonArray != null && jsonArray.length() > 0) {
                int arraySize = jsonArray.length();
                for (int i = 0; i < arraySize; i++) {
                    jsonObjItem = jsonArray.getJSONObject(i);
                    if (jsonObjItem.getString("old").equals(name)) {
                        newName = jsonObjItem.getString("new");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }

        return newName;
    }
}
