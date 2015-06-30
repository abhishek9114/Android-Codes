packagecom.example.calc;

import android.support.v7.app.ActionBarActivity;
importandroid.os.Bundle;
importandroid.view.Menu;
importandroid.view.MenuItem;
importandroid.view.View;
importandroid.widget.Button;
importandroid.widget.EditText;

public class GUI extends ActionBarActivity {
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdot,badd,bsub,bmul,bdiv,beq;
EditTextet;
int val1,val2;
booleanadd,sub,div,mul;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_gui);
  b1=(Button) findViewById(R.id.button1);
  b2=(Button) findViewById(R.id.Button01);
  b3=(Button) findViewById(R.id.Button02);
  b4=(Button) findViewById(R.id.Button03);
  b5=(Button) findViewById(R.id.Button04);
  b6=(Button) findViewById(R.id.Button05);
  b7=(Button) findViewById(R.id.Button06);
  b8=(Button) findViewById(R.id.Button07);
  b9=(Button) findViewById(R.id.Button08);
  b0=(Button) findViewById(R.id.Button09);
  bdot=(Button) findViewById(R.id.Button10);
  badd=(Button) findViewById(R.id.Button11);
  bsub=(Button) findViewById(R.id.Button12);
  bmul=(Button) findViewById(R.id.Button13);
  bdiv=(Button) findViewById(R.id.Button14);
  beq=(Button) findViewById(R.id.Button15);
  et=(EditText) findViewById(R.id.editText1);
  
  b1.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub
    et.setText(et.getText()+"1");
   }
  });
  b2.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub
    et.setText(et.getText()+"2");
   }
  });
  b3.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub
    et.setText(et.getText()+"3");
   }
  });
  b4.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub
    et.setText(et.getText()+"4");
   }
  });
  b5.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub
    et.setText(et.getText()+"5");
   }
  });
  b6.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub
    et.setText(et.getText()+"6");
   }
  });
  b7.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub
    et.setText(et.getText()+"7");
   }
  });
  b8.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub
    et.setText(et.getText()+"8");
   }
  });
  b9.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub
    et.setText(et.getText()+"9");
   }
  });
  b0.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub
    et.setText(et.getText()+"0");
   }
  });
  bdot.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub
    et.setText(et.getText()+".");
   }
  });
  
 badd.setOnClickListener(new View.OnClickListener() {
  
  @Override
  public void onClick(View v) {
   val1=Integer.parseInt(et.getText()+"");
   add=true;
   et.setText(null);
  }
 });
bsub.setOnClickListener(new View.OnClickListener() {
  
  @Override
  public void onClick(View v) {
   val1=Integer.parseInt(et.getText()+"");
   sub=true;
   et.setText(null);
  }
 });
bdiv.setOnClickListener(new View.OnClickListener() {
 
 @Override
 public void onClick(View v) {
  val1=Integer.parseInt(et.getText()+"");
  div=true;
  et.setText(null);
 }
});
bmul.setOnClickListener(new View.OnClickListener() {
 
 @Override
 public void onClick(View v) {
  val1=Integer.parseInt(et.getText()+"");
  mul=true;
  et.setText(null);
 }
});

beq.setOnClickListener(new View.OnClickListener() {
 
 @Override
 public void onClick(View v) {
  val2=Integer.parseInt(et.getText()+"");
  if (add==true) {
   et.setText(val1+val2+"");
   add=false; 
  }
  if (sub==true) {
   et.setText(val1-val2+"");
   sub=false; 
  }
  if (mul==true) {
   et.setText(val1*val2+"");
   mul=false; 
  }
  if (div==true) {
   et.setText(val1/val2+"");
   div=false; 
  }
 }
 
});


 }

 @Override
 publicbooleanonCreateOptionsMenu(Menu menu) {
  // Inflate the menu; this adds items to the action bar if it is present.
  getMenuInflater().inflate(R.menu.gui, menu);
  return true;
 }

 @Override
 publicbooleanonOptionsItemSelected(MenuItem item) {
  // Handle action bar item clicks here. The action bar will
  // automatically handle clicks on the Home/Up button, so long
  // as you specify a parent activity in AndroidManifest.xml.
  int id = item.getItemId();
  if (id == R.id.action_settings) {
   return true;
  }
  returnsuper.onOptionsItemSelected(item);
 }
}

