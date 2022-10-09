package com.example.ailatrieuphu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.DownloadManager;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.skydoves.progressview.ProgressView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtcontent, txtquestion, txtanswer1, txtanwer2, txtanswer3, txtanswer4;
    public int currentquestion = 0;
    List<Question> listquestion;
    public Question mquestion;
    Button btnsupport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();
        listquestion = getListQuestion();
        if (listquestion.isEmpty()) {
            return;
        }
        setDataQuestion(listquestion.get(currentquestion));
        btnsupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(5,20,60,15);
            }
        });
    }

    private void openDialog(int progress1,int progress2,int progress3,int progress4) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_custom_progressview);
        Window window = dialog.getWindow();
        if(window== null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.dismiss();
        dialog.setCancelable(false);

        TextView txtprogressview1 = dialog.findViewById(R.id.txtview1);
        TextView txtprogressview2 = dialog.findViewById(R.id.txtview2);
        TextView txtprogressview3 = dialog.findViewById(R.id.txtview3);
        TextView txtprogressview4 = dialog.findViewById(R.id.txtview4 );

        ProgressView progressView1 = dialog.findViewById(R.id.progress_1);
        ProgressView progressView2 = dialog.findViewById(R.id.progress_2);
        ProgressView progressView3 = dialog.findViewById(R.id.progress_3);
        ProgressView progressView4 = dialog.findViewById(R.id.progress_4);

        Button button = dialog.findViewById(R.id.btnthanks);

        txtprogressview1.setText(progress1+ "%");
        txtprogressview1.setText(progress2+ "%");
        txtprogressview1.setText(progress3+ "%");
        txtprogressview1.setText(progress4+ "%");

        progressView1.setProgress(progress1);
        progressView2.setProgress(progress2);
        progressView3.setProgress(progress3);
        progressView4.setProgress(progress4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void setDataQuestion(Question dataQuestion) {
        if (dataQuestion == null) {
            return;
        }
        mquestion = dataQuestion;

        txtanswer1.setBackgroundResource(R.drawable.shape_xanh);
        txtanwer2.setBackgroundResource(R.drawable.shape_xanh);
        txtanswer3.setBackgroundResource(R.drawable.shape_xanh);
        txtanswer4.setBackgroundResource(R.drawable.shape_xanh);

        String numberquestion = "Question " + dataQuestion.getNumber();
        txtquestion.setText(numberquestion);
        txtcontent.setText(dataQuestion.getContent());
        txtanswer1.setText(dataQuestion.getAnswerList().get(0).getContent());
        txtanwer2.setText(dataQuestion.getAnswerList().get(1).getContent());
        txtanswer3.setText(dataQuestion.getAnswerList().get(2).getContent());
        txtanswer4.setText(dataQuestion.getAnswerList().get(3).getContent());

        txtanswer1.setOnClickListener(this);
        txtanwer2.setOnClickListener(this);
        txtanswer3.setOnClickListener(this);
        txtanswer4.setOnClickListener(this);

    }

    private void anhxa() {
        txtcontent = findViewById(R.id.content);
        txtquestion = findViewById(R.id.question);
        txtanswer1 = findViewById(R.id.answer1);
        txtanwer2 = findViewById(R.id.answer2);
        txtanswer3 = findViewById(R.id.answer3);
        txtanswer4 = findViewById(R.id.answer4);
        btnsupport = findViewById(R.id.support);
    }

    public List<Question> getListQuestion() {
        List<Question> questionlist = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("Gà", true));
        answerList.add(new Answer("Cá", false));
        answerList.add(new Answer("Bò", false));
        answerList.add(new Answer("Lợn", false));

        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("Cẳng", false));
        answerList1.add(new Answer("Đá", true));
        answerList1.add(new Answer("Gối", false));
        answerList1.add(new Answer("Nước", false));

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("Thái Bình", false));
        answerList2.add(new Answer("Hồ Chí Minh", false));
        answerList2.add(new Answer("Hà Nội", true));
        answerList2.add(new Answer("Hải Dương", false));


        questionlist.add(new Question(1, "Con nào là gia cầm", answerList));
        questionlist.add(new Question(2, "Chân cứng , ... mềm", answerList1));
        questionlist.add(new Question(3, " Đâu là thủ đô Việt Nam", answerList2));

        return questionlist;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.answer1:
                txtanswer1.setBackgroundResource(R.drawable.shape_cam);
                CheckQuestion(txtanswer1, mquestion, mquestion.getAnswerList().get(0));
                break;
            case R.id.answer2:
                txtanwer2.setBackgroundResource(R.drawable.shape_cam);
                CheckQuestion(txtanwer2, mquestion, mquestion.getAnswerList().get(1));
                break;
            case R.id.answer3:
                txtanswer3.setBackgroundResource(R.drawable.shape_cam);
                CheckQuestion(txtanswer3, mquestion, mquestion.getAnswerList().get(2));
                break;
            case R.id.answer4:
                txtanswer4.setBackgroundResource(R.drawable.shape_cam);
                CheckQuestion(txtanswer4, mquestion, mquestion.getAnswerList().get(3));
                break;
        }
    }

    private void CheckQuestion(TextView textView, Question question, Answer answer) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (answer.isCorect) {
                    textView.setBackgroundResource(R.drawable.shape_xanh_la_cay);
                    nextquestion();
                } else {
                    textView.setBackgroundResource(R.drawable.shape_do);
                    showcorrect(question);
                    ganmeover();
                }
            }
        }, 1000);
    }

    private void ganmeover() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showDialog("Game over");
            }
        }, 1000);
    }

    private void showcorrect(Question question) {
        if (question == null || question.getAnswerList() == null || question.getAnswerList().isEmpty()) {
            return;
        }
        if (question.getAnswerList().get(0).isCorect) {
            txtanswer1.setBackgroundResource(R.drawable.shape_xanh_la_cay);
        } else if (question.getAnswerList().get(1).isCorect) {
            txtanwer2.setBackgroundResource(R.drawable.shape_xanh_la_cay);
        } else if (question.getAnswerList().get(2).isCorect) {
            txtanswer3.setBackgroundResource(R.drawable.shape_xanh_la_cay);
        } else if (question.getAnswerList().get(3).isCorect) {
            txtanswer4.setBackgroundResource(R.drawable.shape_xanh_la_cay);
        }
    }

    private void nextquestion() {
        if (currentquestion == listquestion.size() - 1) {
            showDialog("you wwin");
        } else {
            currentquestion++;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    setDataQuestion(listquestion.get(currentquestion));
                }
            }, 1000);
        }
    }

    private void showDialog(String messege) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(messege);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                currentquestion = 0;
                setDataQuestion(listquestion.get(currentquestion));
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}