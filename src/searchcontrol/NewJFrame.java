/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchcontrol;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import util.Helper;

public class NewJFrame extends javax.swing.JFrame {

    private String requester;
    private String manager;
    private String managerEmpId;
    private String jobTitle;
    private String department;
    private String location;
    private String officeNo;
    private String mobileNo;
    private String today;
    private static String username;
    private String employeeId;

    public NewJFrame() {
        initComponents();
    }

    public NewJFrame(String username) {
        this.username = username;
        initComponents();
        initializeCode();
    }

    public void initializeCode() {
        Helper helper = new Helper();
        Hashtable<String, String> env = helper.ldapConnect("ldap://domain:389/DC=aaa,DC=sss,DC=ddd",
                "simple", "CN=first last,OU=aaaaa s,OU=aaaa,OU=dddd,OU=ffff,OU=gggg,OU=hhhhh,DC=smrc,DC=ddddd,DC=ssss",
                "password");

        DirContext context = null;
        try {
            context = new InitialDirContext(env);
        } catch (AuthenticationNotSupportedException ex) {
            System.out.println("The authentication is not supported by the server");
        } catch (AuthenticationException ex) {
            System.out.println("incorrect password or username");
        } catch (NamingException ex) {
            System.out.println("error when trying to create the context");
        }

        SearchControls searchControls = new SearchControls();
        Attributes attributes = new BasicAttributes();
        String filter = "(&(sn=*)(sAMAccountName=" + username + "))";
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        try {
            NamingEnumeration<SearchResult> answer = context.search("OU=aaassss",
                    filter, searchControls);
            while (answer.hasMoreElements()) {
                SearchResult searchResult = answer.next();
                username = searchResult.getAttributes().get("cn").get(0).toString();
            }
        } catch (NamingException ex) {
            Logger.getLogger(SearchControlApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        welcome.setText("Welcome " + username);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        employeeNameInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        requesterInput = new javax.swing.JTextField();
        fetchButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        managerNamesInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jobTitleInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        locationInput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lineManagerEmpIdInput = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        departmentInput = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        mobileInput = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        officeNoInput = new javax.swing.JTextField();
        genrateForm = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        todayDate = new javax.swing.JTextField();
        welcome = new javax.swing.JLabel();
        filename = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ticketNoInput = new javax.swing.JTextField();
        staff = new javax.swing.JRadioButton();
        contractor = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        employeeIdInput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        employeeNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeNameInputActionPerformed(evt);
            }
        });

        jLabel1.setText("Employee account");

        jLabel2.setText("Requester Name");

        requesterInput.setEditable(false);
        requesterInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requesterInputActionPerformed(evt);
            }
        });

        fetchButton.setText("Fetch");
        fetchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fetchButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Manager's Name");

        managerNamesInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerNamesInputActionPerformed(evt);
            }
        });

        jLabel4.setText("Job Title");

        jobTitleInput.setEditable(false);
        jobTitleInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobTitleInputActionPerformed(evt);
            }
        });

        jLabel5.setText("Location");

        locationInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationInputActionPerformed(evt);
            }
        });

        jLabel6.setText("Line Manager Employee Id");

        lineManagerEmpIdInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineManagerEmpIdInputActionPerformed(evt);
            }
        });

        jLabel7.setText("Department");

        departmentInput.setEditable(false);
        departmentInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentInputActionPerformed(evt);
            }
        });

        jLabel8.setText("Mobile No");

        mobileInput.setEditable(false);
        mobileInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileInputActionPerformed(evt);
            }
        });

        jLabel9.setText("Office no.");

        officeNoInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                officeNoInputActionPerformed(evt);
            }
        });

        genrateForm.setText("Print form");
        genrateForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genrateFormActionPerformed(evt);
            }
        });

        jLabel10.setText("Date");

        todayDate.setEditable(false);
        todayDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todayDateActionPerformed(evt);
            }
        });

        jLabel11.setText("Ticket no.");

        ticketNoInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketNoInputActionPerformed(evt);
            }
        });

        buttonGroup2.add(staff);
        staff.setText("Staff");
        staff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffActionPerformed(evt);
            }
        });

        buttonGroup2.add(contractor);
        contractor.setText("Contractor");

        jLabel12.setText("Employee Id");

        employeeIdInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeIdInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(staff)
                .addGap(18, 18, 18)
                .addComponent(contractor)
                .addGap(241, 241, 241))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(genrateForm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jobTitleInput, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(locationInput, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(employeeNameInput)
                                        .addComponent(todayDate, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(requesterInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fetchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(departmentInput, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mobileInput, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(officeNoInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ticketNoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(filename, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(managerNamesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lineManagerEmpIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(employeeIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fetchButton)
                    .addComponent(jLabel11)
                    .addComponent(ticketNoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(todayDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff)
                    .addComponent(contractor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(requesterInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jobTitleInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(locationInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(departmentInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mobileInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(officeNoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(managerNamesInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lineManagerEmpIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(genrateForm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(filename, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeNameInputActionPerformed

    private void requesterInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requesterInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requesterInputActionPerformed

    private void managerNamesInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerNamesInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_managerNamesInputActionPerformed

    private void jobTitleInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobTitleInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobTitleInputActionPerformed

    private void locationInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locationInputActionPerformed

    private void lineManagerEmpIdInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineManagerEmpIdInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lineManagerEmpIdInputActionPerformed

    private void departmentInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentInputActionPerformed

    private void mobileInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileInputActionPerformed

    private void officeNoInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_officeNoInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_officeNoInputActionPerformed

    private void flushData() {
        requesterInput.setText(null);
        managerNamesInput.setText(null);
        employeeIdInput.setText(null);
        lineManagerEmpIdInput.setText(null);
        lineManagerEmpIdInput.setText(null);
        jobTitleInput.setText(null);
        departmentInput.setText(null);
        location = "";
        officeNo = "";
        todayDate.setText(null);
        mobileInput.setText(null);
        contractor.setSelected(false);
        staff.setSelected(false);
        requester = "";
        manager = "";
        managerEmpId = "";
        jobTitle = "";
        department = "";
        location = "";
        officeNo = "";
        mobileNo = "";
        today = "";
        employeeId = "";
    }

    private void fetchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fetchButtonActionPerformed
        flushData();
        Helper helper = new Helper();
        Hashtable<String, String> env = helper.ldapConnect("ldap://mydomain.com:389/DC=jjjj,DC=fdd,DC=aaa",
                "simple", "CN=first last,OU=asdasd,OU=aaaaa,OU=ssss,OU=Users,OU=sdddd,OU=fffff,DC=smrc,DC=dddd,DC=ssss",
                "password");

        DirContext context = null;
        try {
            context = new InitialDirContext(env);
        } catch (AuthenticationNotSupportedException ex) {
            System.out.println("The authentication is not supported by the server");
        } catch (AuthenticationException ex) {
            System.out.println("incorrect password or username");
        } catch (NamingException ex) {
            System.out.println("error when trying to create the context");
        }

        SearchControls searchControls = new SearchControls();
        Attributes attributes = new BasicAttributes();
        String filter = "(&(sn=*)(sAMAccountName=" + employeeNameInput.getText().trim() + "))";
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        today = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        try {
            NamingEnumeration<SearchResult> answer = context.search("OU=dfdfgd",
                    filter, searchControls);
            while (answer.hasMoreElements()) {
                SearchResult searchResult = answer.next();
                requester = searchResult.getAttributes().get("name").get(0).toString();
                requesterInput.setText(requester);
                manager = searchResult.getAttributes().get("manager").get(0).toString().split(",")[0].split("=")[1];
                managerNamesInput.setText(manager);
                if (searchResult.getAttributes().get("employeeNumber") != null) {
                    employeeId = searchResult.getAttributes().get("employeeNumber").get(0).toString();
                    employeeIdInput.setText(employeeId);
                }
                if (searchResult.getAttributes().get("employeeSupervisorEmpNo") != null) {
                    managerEmpId = searchResult.getAttributes().get("employeeSupervisorEmpNo").get(0).toString();
                    lineManagerEmpIdInput.setText(managerEmpId);
                } else {
                    System.out.println("manager............. " + manager);
                    String nameFilter = "(&(sn=*)(cn=" + manager + "))";
                    SearchControls sControls = new SearchControls();
                    sControls.setSearchScope(sControls.SUBTREE_SCOPE);
                    NamingEnumeration<SearchResult> naming = context.search("OU=hgfhfghfd",
                            nameFilter, sControls);
                    while (naming.hasMoreElements()) {
                        SearchResult sResult = naming.next();
                        managerEmpId = sResult.getAttributes().get("employeeNumber").get(0).toString();
                        lineManagerEmpIdInput.setText(managerEmpId);
                    }
                }
                jobTitle = searchResult.getAttributes().get("title").get(0).toString();
                jobTitleInput.setText(jobTitle);
                department = searchResult.getAttributes().get("department").get(0).toString();
                departmentInput.setText(department);
                location = "";
                officeNo = "";
                mobileNo = searchResult.getAttributes().get("mobile").get(0).toString();
                todayDate.setText(today);
                mobileInput.setText(mobileNo);
                if (employeeId == null || employeeId.length() < 5) {
                    contractor.setSelected(true);
                } else if (employeeId != null && employeeId.length() >= 5) {
                    staff.setSelected(true);
                }
            }
        } catch (NamingException ex) {
            Logger.getLogger(SearchControlApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_fetchButtonActionPerformed

    private void genrateFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genrateFormActionPerformed
        System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
        try (PDDocument doc = PDDocument.load(new File("filepath"))) {
            PDAcroForm acroForm = doc.getDocumentCatalog().getAcroForm();
            PDResources formResources = acroForm.getDefaultResources();
            PDType0Font font = PDType0Font.load(doc, new File("C:\\data\\arial.ttf"));
//            acroForm.setXFA(null);
            formResources.put(COSName.getPDFName("F0"), font);
//            for (PDField field : acroForm.getFields()) {
//                if (field.getFieldType().equals("Tx")) {
//                    field.setValue(field.getFullyQualifiedName());
//                }
//            }
            acroForm.getField("Text1").setValue(today);
            acroForm.getField("Text36").setValue(requester);
            acroForm.getField("Text40").setValue(jobTitle);
            acroForm.getField("Text42").setValue(mobileNo);
            acroForm.getField("Text41").setValue(officeNo);
            acroForm.getField("Text38").setValue(manager);
            acroForm.getField("Text4").setValue(department);
            acroForm.getField("Text39").setValue(managerEmpId);
            acroForm.getField("Text37").setValue(employeeId);
            acroForm.getField("Text33").setValue(ticketNoInput.getText());
            acroForm.getField("Text53").setValue(username);
            acroForm.getField("Text5").setValue(requester);
            if (staff.isSelected()) {
                PDField staff = acroForm.getField("Check Box34");
                ((PDCheckBox) staff).check();
            } else {
                PDField contractor = acroForm.getField("Check Box1");
                ((PDCheckBox) contractor).check();
            }
//        formField.setValue(new StringBuilder(new ArabicShaping(ArabicShaping.LETTERS_SHAPE_TASHKEEL_ISOLATED).shape(s)).reverse().toString());
//        formField.setDefaultAppearance("/Helv 0 Tf 0 g");
            System.out.println(requester.replace(" ", "_"));
            doc.save("c:\\data\\ " + requester.replace(" ", "_") + "asset.pdf");
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        filename.setText("c:\\data\\ " + requester.replace(" ", "_") + "asset.pdf");

    }//GEN-LAST:event_genrateFormActionPerformed

    private void todayDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todayDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_todayDateActionPerformed

    private void ticketNoInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketNoInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ticketNoInputActionPerformed

    private void staffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffActionPerformed

    private void employeeIdInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeIdInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeIdInputActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton contractor;
    private javax.swing.JTextField departmentInput;
    private javax.swing.JTextField employeeIdInput;
    private javax.swing.JTextField employeeNameInput;
    private javax.swing.JButton fetchButton;
    private javax.swing.JLabel filename;
    private javax.swing.JButton genrateForm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jobTitleInput;
    private javax.swing.JTextField lineManagerEmpIdInput;
    private javax.swing.JTextField locationInput;
    private javax.swing.JTextField managerNamesInput;
    private javax.swing.JTextField mobileInput;
    private javax.swing.JTextField officeNoInput;
    private javax.swing.JTextField requesterInput;
    private javax.swing.JRadioButton staff;
    private javax.swing.JTextField ticketNoInput;
    private javax.swing.JTextField todayDate;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
