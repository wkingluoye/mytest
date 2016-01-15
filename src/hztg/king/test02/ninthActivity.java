package hztg.king.test02;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * @author king
 * 
 */
public class ninthActivity extends Activity {
	private EditText logWrapper;
	private String upFlag = ""  ; 
	private ImageView animationIV;
	private RelativeLayout bg_voice;
	private AnimationDrawable animationDrawable;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ninth);
		if (android.os.Build.VERSION.SDK_INT > 9) { 
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); 
			StrictMode.setThreadPolicy(policy); 
			} 
		logWrapper = (EditText) findViewById(R.id.edt09_ShowLog);
		
		// /storage/sdcard0/com.tiange.hz.happy88/voice/voice13793863370mp3
		animationIV = (ImageView)findViewById(R.id.animationIV);
		bg_voice  = (RelativeLayout) findViewById(R.id.bg_voice);
		bg_voice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("停止");
				if(animationDrawable != null){
					animationDrawable.stop();
					animationDrawable  = null ;
				}
				
				
				animationIV.setImageResource(R.drawable.chatto_voice_playing);
			}
		});
		findViewById(R.id.btn09_upload).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						//动画演示
						//animationIV.setBackgroundColor(0);
						animationIV.setImageResource(R.anim.voice_to_icon_anim);
						animationDrawable = (AnimationDrawable) animationIV.getDrawable();
						animationDrawable.start();

						
						
						// showRunLog(""+System.currentTimeMillis());
						/*showRunLog("/storage/sdcard0/com.tiange.hz.happy88/voice/voice1379386337031.mp3");
						// http://v.jhtg.cn/api/index.php?act=upload&username=zm&password=123456&uploadedfile=***&platformid=1&userid=190008"
						Map<String, String> params = new HashMap<String, String>();
						params.put("act", "upload");
						params.put("username", "wkingluoye");
						params.put("password", "*0214w0");
						params.put("platformid", "1");
						params.put("userid", "726094299");
						try {
							// 得到SDCard的目录
							File uploadFile = new File("/storage/sdcard0/com.tiange.hz.happy88/voice/voice1379386337031.mp3");
							// 上传音频文件
							FormFile formfile = new FormFile("voice1379386337031.mp3", uploadFile,
									"uploadedfile", "audio/mpeg");
							upFlag = HttpSocket.post(
									"http://v.jhtg.cn/api/index.php", params,
									formfile);
							//Toast.makeText(ninthActivity.this, "上传成功", 1).show();
							Log.i("Up", "上传成功:"+upFlag);
						     JSONObject p=null;
						     int ret = 0 ; 
						     try{
						   	  p = new JSONObject(upFlag);
						   	  //p.isNull(name)
						   	  ret = p.getInt("ret");
						   	  Log.i("Up", "ret:"+ret);
						     }catch(Exception e){
						   	  e.printStackTrace();
						     }
						} catch (Exception e) {
							Toast.makeText(ninthActivity.this, "上传失败"+e, 1)
									.show();
							Log.i("Up", "上传失败:"+e);
						}*/

					}
				});
	}
	private void showRunLog(String log) {

		logWrapper.append(Html.fromHtml("<img src='"
				+ R.drawable.chatting_setmode_voice_btn_normal + "'/>" + log
				+ "\n", imgLocGetter, null));
		// logWrapper.append(Html.fromHtml("<img src='http://home.cnblogs.com/images/ico_money_big.gif'/>"+log+"\n",imgUrlGetter,null));
	}

	ImageGetter imgUrlGetter = new Html.ImageGetter() {
		@Override
		public Drawable getDrawable(String source) {
			Drawable drawable = null;
			drawable = Drawable.createFromPath(source); // Or fetch it from the
														// URL
			// Important
			drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
					drawable.getIntrinsicHeight());
			return drawable;
		}
	};

	ImageGetter imgLocGetter = new Html.ImageGetter() {
		@Override
		public Drawable getDrawable(String source) {
			int id = Integer.parseInt(source);
			Drawable d = null;
			try {
				d = getResources().getDrawable(id);
				d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
			} catch (OutOfMemoryError e) {
				System.gc();
				e.printStackTrace();
			}

			return d;
		}
	};
	private Handler uiHandler = new Handler() {
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			try {
				int nCommand = msg.what;
				switch (nCommand) {
				/* 显示系统消息 */

				case 1:
					showRunLog("uiHandler"+msg.obj.toString());
					break;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	
	/** 获取Handler */
	public Handler getHandler() {
		return uiHandler;
	}
}
