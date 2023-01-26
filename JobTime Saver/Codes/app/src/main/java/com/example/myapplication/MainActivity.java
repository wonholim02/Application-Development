package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

// page for cover letter
public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    EditText name;
    EditText phone;
    EditText address;
    EditText email;
    EditText date;
    EditText position;
    EditText company;
    EditText major;
    EditText school;
    EditText interest;
    EditText organization;
    EditText project;
    EditText website;
    EditText character;
    EditText year;
    EditText skill;
    EditText value;
    EditText experience;
    EditText skills;
    TextView result;
    String namei, phonei, addressi, emaili, datei, positioni, companyi, majori, schooli, interesti, organizationi, projecti, websitei, characteri, yeari, skilli, valuei, experiencei, skillsi;
    private Button button19;
    private Button button15;
    private Button button16;
    private Button button17;
    private Button button18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.logo);
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#009688"));
        actionBar.setBackgroundDrawable(colorDrawable);


        button17 = (Button) findViewById(R.id.button17);
        button15 = (Button) findViewById(R.id.button15);
        button16 = (Button) findViewById(R.id.button16);
        button18 = (Button) findViewById(R.id.button18);
        button19 = (Button) findViewById(R.id.button19);
        result = (TextView) findViewById(R.id.textView29);

        name = (EditText) findViewById(R.id.editTextTextPersonName);
        phone = (EditText) findViewById(R.id.editTextTextPersonName2);
        address = (EditText) findViewById(R.id.editTextTextPersonName3);
        email = (EditText) findViewById(R.id.editTextTextPersonName4);
        date = (EditText) findViewById(R.id.editTextTextPersonName5);
        position = (EditText) findViewById(R.id.editTextTextPersonName6);
        company = (EditText) findViewById(R.id.editTextTextPersonName7);
        major = (EditText) findViewById(R.id.editTextTextPersonName9);
        school = (EditText) findViewById(R.id.editTextTextPersonName10);
        interest = (EditText) findViewById(R.id.editTextTextPersonName11);
        organization = (EditText) findViewById(R.id.editTextTextPersonName12);
        project = (EditText) findViewById(R.id.editTextTextPersonName13);
        website = (EditText) findViewById(R.id.editTextTextPersonName15);
        character = (EditText) findViewById(R.id.editTextTextPersonName17);
        year = (EditText) findViewById(R.id.editTextTextPersonName18);
        skill = (EditText) findViewById(R.id.editTextTextPersonName19);
        value = (EditText) findViewById(R.id.editTextTextPersonName20);
        experience = (EditText) findViewById(R.id.editTextTextPersonName21);
        skills = (EditText) findViewById(R.id.editTextTextPersonName22);

        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.coverletter);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.coverletter:
                        return true;
                    case R.id.elecsignature:
                        startActivity(new Intent(getApplicationContext(), ElecSign.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.usefulinfo:
                        startActivity(new Intent(getApplicationContext(), UsefulInfo.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.tips:
                        startActivity(new Intent(getApplicationContext(), Tips.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);

        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namei = name.getText().toString();
                phonei = phone.getText().toString();
                addressi = address.getText().toString();
                addressi = address.getText().toString();
                emaili = email.getText().toString();
                datei = date.getText().toString();
                positioni = position.getText().toString();
                companyi = company.getText().toString();
                majori = major.getText().toString();
                schooli = school.getText().toString();
                interesti = interest.getText().toString();
                organizationi = organization.getText().toString();
                projecti = project.getText().toString();
                websitei = website.getText().toString();
                characteri = character.getText().toString();
                yeari = year.getText().toString();
                skilli = skill.getText().toString();
                valuei = value.getText().toString();
                experiencei = experience.getText().toString();
                skillsi = skills.getText().toString();
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result1(v);
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result2(v);
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result3(v);
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result4(v);
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_feedback:
                startActivity(new Intent(this, Feedback.class));
                return true;
            case R.id.action_about:
                startActivity(new Intent(this,About.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void result1(View view){
        result.setText("" + namei + " \n\n" + phonei + " | " +addressi + " | " + emaili + " \n\n" + datei + " \n\nDear Hiring Manager, \n\n" +
                " I’m delighted to apply for the " + positioni + " at " + companyi + ". I found that your company’s needs align with my strength and interest perfectly while reviewing the job description. \n\n" +
                " Since I have been highly interested in, and have advanced knowledge in " + interesti + ", I majored " + majori + " at " + schooli + "for development of my expertise. Further, following my interest, I worked at " +
                organizationi + " as " + positioni + " and mainly worked on  " + projecti + ". Through that experience, I got expertise in " +
                skilli + ". This experience helped me to become confident and professional in areas that I’m passionate about. Now, it’s time for me to take another large step. I’m looking for a position like " + positioni +
                "so that I can performed what I learned. I will be the best solution for your company’s needs for " +positioni + ". \n\n I am confident that my unique ability which comes from both my experience and interest in these related fields will enhance your company to progress dramatically. The attached resume includes further information about my valuable experiences. \n\n Thank you for your time and consideration, and I look forward to hearing from you soon. \n\n" +
                "Best regards, \n\n" + namei);
    }
    public void result2(View view){
        result.setText("" + namei + " \n\n" + phonei + " | " +addressi + " | " + emaili + " | " + websitei + " \n\n" + datei + "\n\nDear Hiring Manager, \n\n" +
                " As an " + characteri + " person,  I’m delighted to apply for the " + positioni + " at " + companyi + ". While reading the job description, \n\n" +
                " I was excited to find that my strength and experience aligns with "+ companyi +"’s needs and mission. " + "\n\n I believe that I can bring my unique value " +
                "to your company through my valuable experiences in the industry. After studying " + majori + " at " + schooli + " for " + yeari + "years, I" +
                " worked at " + organizationi + " as " + positioni + " and worked on " + projecti + ". Through that experience, I got expertise in " +
                skilli + ". This experience will not only help me to adapt to new system but also let me provide innovative idea for the company. " +
                "The attached resume includes further information about my experiences. \n\n" + " I strongly believe that I can bring Value that one can bring to your company, " +
                "and contribute to a great progress of your company. \n\n" + "Thank you for your time and consideration, and I look forward to hearing from you soon. \n\n" +
                "Best regards, \n\n" + namei);
    }

    public void result3(View view){
        result.setText("" + namei + "\n\n" + phonei + " " + addressi + " " + emaili + " \n ---------------------------------------------------\n\n" +
                datei + "\n\n" + "Dear Hiring Manager, \n\n" + " I was thrilled to see the job opening in your " + positioni + "at" + companyi +
                "." + experiencei + "\n\n" + " Upon learning about past experience, I was eager to contact you with my interest, " +  interesti + "." +
                "I have well-rounded skill set in " + skillsi + "\n\n" + " I would describe myself as someone who is/has " +
                characteri + ". I would like to put these characteristics to use within " + companyi +". \n\n" + "" +
                " I believe that i would be the ideal candidate for " + positioni + ". I look forward to hearing from you " +
                "to discuss how my experience and qualifications will prove values in " + companyi + ". \n\n Thank you for your time and " +
                "consideration. \n\n Sincerely, \n\n" + namei);
    }

    public void result4(View view){
        result.setText("" + namei + "\n\n" + emaili + " \t " + phonei + " \t " + addressi + " \n" +
                datei + "\n\n" + "Dear Hiring Manager, \n\n" + " I would like to express my strong interest in " + positioni + "at" + companyi +
                ". I have experience with " + experiencei + "\n\n" + " Upon learning about past experience, I was eager to contact you with my interest, " +  interesti + "." +
                "I have well-rounded skill set in " + skillsi + "\n\n" + " I would describe myself as someone who is/has " +
                characteri + ". I would like to put these characteristics to use within " + companyi +". \n\n" + "" +
                " I am excited at the prospect of bringing my talents to " + companyi + ". I look forward to hearing from you to discuss how my experience and qualifications will prove values in " +
                companyi + ". \n\nThank you for your time and consideration. \n\nSincerely, \n\n" + namei);
    }

}