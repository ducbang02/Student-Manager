/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

import BangDiem.BangDiem;
import BangDiem.BangDiemDAO;
import BangDiem.IBangDiemDAO;
import BangDiem.frmBangDiem;
import Check.Check;
import LopHoc.ILopHocDAO;
import LopHoc.LopHoc;
import MonHoc.IMonHocDAO;
import MonHoc.MonHoc;
import SinhVien.ISinhVienDAO;
import SinhVien.SinhVien;
import SinhVien.SinhVienDAO;
import static SinhVien.frmSinhVien.regexDDMMYYYY;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anonymous
 */
public class Search extends javax.swing.JPanel {

    private DefaultTableModel dtm;

    private DefaultTableModel dtmMark;
    ArrayList<BangDiem> listbdiem = null;
    ArrayList<LopHoc> allClass = null;

    private DefaultComboBoxModel dcbmHS;
    private DefaultComboBoxModel dcbmLanThi;
    private DefaultButtonModel dbm;
    private DefaultComboBoxModel dcbmMaSV;
    private DefaultComboBoxModel dcbmMaMH;
    private DefaultComboBoxModel dcbmMaLop;
    ArrayList<SinhVien> listsv = null;
    ArrayList<MonHoc> listmh = null;

    ArrayList<LopHoc> listML = null;

    /**
     * Creates new form Search
     */
    public Search() {
        try {
            initComponents();
            jPanel8.setVisible(false);
            jPanel5.setVisible(false);
            jPanel7.setVisible(false);
            jPanel6.setVisible(false);

            DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
            ILopHocDAO lopHocDao = (ILopHocDAO) Class.forName("LopHoc.LopHocDAO").newInstance();
            allClass = lopHocDao.getAll();
            for (LopHoc lh : allClass) {
                dcbm.addElement(lh.getMalop());
            }
            jcblop2.setModel(dcbm);

            //Load Cb Mon Hoc
            dcbmMaMH = new DefaultComboBoxModel();
            IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("MonHoc.MonHocDAO").newInstance();
            listmh = monHocDAO.getAll();
            for (MonHoc mh : listmh) {
                dcbmMaMH.addElement(mh.getMamh());
            }
            jcbMaMH.setModel(dcbmMaMH);

            //Load Ma Lop
            dcbmMaLop = new DefaultComboBoxModel();
            ILopHocDAO lopHocDAO = (ILopHocDAO) Class.forName("LopHoc.LopHocDAO").newInstance();
            listML = lopHocDAO.getAll();
            for (LopHoc lopHoc : listML) {
                dcbmMaLop.addElement(lopHoc.getMalop());
            }
            jcbMaLop.setModel(dcbmMaLop);

            //load ma sv
            dcbmMaSV = new DefaultComboBoxModel();
            ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("SinhVien.SinhVienDAO").newInstance();
            listsv = sinhVienDAO.getAll();
            //  dcbmMaSV.removeAllElements();
            for (SinhVien sv : listsv) {
                dcbmMaSV.addElement(sv.getMasv());
            }
            jcbMasv.setModel(dcbmMaSV);

            //Load Lan Thi
            dcbmLanThi = new DefaultComboBoxModel();
            dcbmLanThi.addElement("0");
            dcbmLanThi.addElement("1");
            dcbmLanThi.addElement("2");
            dcbmLanThi.addElement("3");
            dcbmLanThi.addElement("4");
            dcbmLanThi.addElement("5");
            dcbmLanThi.addElement("6");
            jcbLanthi.setModel(dcbmLanThi);

            //Load He So
            dcbmHS = new DefaultComboBoxModel();
            dcbmHS.addElement("0");
            dcbmHS.addElement("1");
            dcbmHS.addElement("2");
            dcbmHS.addElement("3");
            dcbmHS.addElement("4");
            jcbHeSo.setModel(dcbmHS);

            //TIm kiem sinh vien theo ma lop
            dtm = new DefaultTableModel();

            dtm.addColumn("ID");
            dtm.addColumn("Họ Tên");
            dtm.addColumn("ID Lớp");
            dtm.addColumn("Hệ ĐT");
            dtm.addColumn("Ngày Sinh");
            dtm.addColumn("Địa Chỉ");
            dtm.addColumn("Giới Tính");
            dtm.addColumn("Số ĐT");
            jtbTTSV.setModel(dtm);

            //TIm Kiem diem theo ma sv
            dtmMark = new DefaultTableModel();
            dtmMark.addColumn("Mã Sinh Viên");
            dtmMark.addColumn("Mã Môn Học");
            dtmMark.addColumn("Lần Thi");
            dtmMark.addColumn("Hệ Số");
            dtmMark.addColumn("Điểm");
            dtmMark.addColumn("Trạng Thái");
            jtbbangdiem.setModel(dtmMark);
        } catch (InstantiationException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbTTSV = new javax.swing.JTable();
        jtfmalop = new javax.swing.JTextField();
        jbtSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jtfMaSV2 = new javax.swing.JTextField();
        jtfHoTen2 = new javax.swing.JTextField();
        jcblop2 = new javax.swing.JComboBox();
        jtfHeDaoTao2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jtfDienThoai2 = new javax.swing.JTextField();
        jrbsex2 = new javax.swing.JRadioButton();
        jtfDiaChi2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jtfngaysinh2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jbtUpdate1 = new javax.swing.JButton();
        jbtDelete1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jtfmasv = new javax.swing.JTextField();
        jbtnsearchmasv = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbbangdiem = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jtfDiem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcbLanthi = new javax.swing.JComboBox();
        jcbHeSo = new javax.swing.JComboBox();
        jrbTrangthai = new javax.swing.JRadioButton();
        jcbMasv = new javax.swing.JComboBox();
        jcbMaMH = new javax.swing.JComboBox();
        jcbMaLop = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jbtUpdateBD = new javax.swing.JButton();
        jbtDeleteBD = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jtbTTSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sinh Viên", "Họ Tên", "Lớp", "Hệ Đào Tạo", "Ngày Sinh", "Địa Chỉ", "Giới Tính", "Số Điện Thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbTTSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtbTTSVMouseReleased(evt);
            }
        });
        jtbTTSV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbTTSVKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtbTTSV);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );

        jtfmalop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfmalopActionPerformed(evt);
            }
        });
        jtfmalop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfmalopKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfmalopKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfmalopKeyTyped(evt);
            }
        });

        jbtSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtSearch.setForeground(new java.awt.Color(0, 0, 255));
        jbtSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search2.png"))); // NOI18N
        jbtSearch.setText("Search");
        jbtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSearchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nhập Mã Lớp");

        jPanel8.setBackground(new java.awt.Color(153, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jPanel8.setForeground(new java.awt.Color(153, 153, 255));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 204));
        jLabel21.setText("Lớp");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 204));
        jLabel22.setText("Mã Sinh Viên");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 204));
        jLabel23.setText("Họ Tên");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 204));
        jLabel24.setText("Hệ Đào Tạo");

        jtfMaSV2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMaSV2ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 204));
        jLabel25.setText("Số Điện Thoại");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 204));
        jLabel26.setText("Giới Tính");

        jrbsex2.setText("Nam/Nữ");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 204));
        jLabel27.setText("Địa Chỉ");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 204));
        jLabel28.setText("Ngày Sinh");

        jLabel29.setText("(dd/MM/yyyy)");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcblop2, 0, 163, Short.MAX_VALUE)
                    .addComponent(jtfHoTen2)
                    .addComponent(jtfHeDaoTao2)
                    .addComponent(jtfMaSV2))
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel26))
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfDiaChi2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jtfngaysinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29))
                    .addComponent(jrbsex2)
                    .addComponent(jtfDienThoai2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfMaSV2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfHoTen2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcblop2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfHeDaoTao2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel28))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfngaysinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDiaChi2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jrbsex2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDienThoai2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jbtUpdate1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtUpdate1.setForeground(new java.awt.Color(255, 0, 51));
        jbtUpdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        jbtUpdate1.setText("Update");
        jbtUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpdate1ActionPerformed(evt);
            }
        });

        jbtDelete1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtDelete1.setForeground(new java.awt.Color(255, 0, 0));
        jbtDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        jbtDelete1.setText("Delete");
        jbtDelete1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbtDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDelete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtDelete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtUpdate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jbtUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jbtDelete1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jtfmalop, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfmalop, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tìm Sinh Viên Theo Mã Lớp", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jtfmasv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfmasvActionPerformed(evt);
            }
        });
        jtfmasv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfmasvKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfmasvKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfmasvKeyTyped(evt);
            }
        });

        jbtnsearchmasv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnsearchmasv.setForeground(new java.awt.Color(0, 0, 255));
        jbtnsearchmasv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search2.png"))); // NOI18N
        jbtnsearchmasv.setText("Search");
        jbtnsearchmasv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnsearchmasvActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Nhập Mã Sinh Viên");

        jtbbangdiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbbangdiem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtbbangdiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtbbangdiemMouseReleased(evt);
            }
        });
        jtbbangdiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbbangdiemKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jtbbangdiem);

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText("Mã Sinh Viên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Mã Môn Học");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Lần Thi");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Hệ Số");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Điểm");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Trạng Thái");

        jrbTrangthai.setText("Bật/Tắt");

        jcbMaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMaLopActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("Mã Lớp");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbMaMH, 0, 133, Short.MAX_VALUE)
                    .addComponent(jcbMaLop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbMasv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbLanthi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbTrangthai))
                .addGap(25, 25, 25))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbMasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jcbHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jrbTrangthai)
                                    .addComponent(jLabel7)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jcbLanthi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(30, 30, 30)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jbtUpdateBD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtUpdateBD.setForeground(new java.awt.Color(255, 0, 51));
        jbtUpdateBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        jbtUpdateBD.setText("Update");
        jbtUpdateBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpdateBDActionPerformed(evt);
            }
        });

        jbtDeleteBD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtDeleteBD.setForeground(new java.awt.Color(255, 0, 51));
        jbtDeleteBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Remove.png"))); // NOI18N
        jbtDeleteBD.setText("Delete");
        jbtDeleteBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteBDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtUpdateBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtDeleteBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jbtUpdateBD)
                .addGap(27, 27, 27)
                .addComponent(jbtDeleteBD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jtfmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnsearchmasv)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnsearchmasv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tìm Điểm Theo Mã Sinh Viên", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtbTTSVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTTSVMouseReleased
        jPanel8.setVisible(true);
        jPanel5.setVisible(true);

        loadDataDownCoponnent();
    }//GEN-LAST:event_jtbTTSVMouseReleased
    private static Object[] toObjectData(SinhVien sv) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(sv.getNgaysinh());

        boolean flag = sv.isGioitinh();
        String gioitinh = "Nam";
        if (!flag) {
            gioitinh = "Nữ";
        }
        Object[] objectData = {sv.getMasv(), sv.getTensv(), sv.getMalop(),
            sv.getHedaotao(), date, sv.getDiachi(), gioitinh, sv.getSodt()};
        return objectData;
    }

    public void timkiem() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        String malop = jtfmalop.getText() + "%";
        try {
            try {
                ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("SinhVien.SinhVienDAO").newInstance();
                ArrayList<SinhVien> list = sinhVienDAO.findByIDLop(malop);
                for (SinhVien sv : list) {
                    dtm.addRow(toObjectData(sv));
                }
            } catch (InstantiationException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void timKiemDiem() {
        while (dtmMark.getRowCount() > 0) {
            dtmMark.removeRow(0);
        }
        try {

            String masv = jtfmasv.getText() + "%";
            IBangDiemDAO bangDiemDAO = (IBangDiemDAO) Class.forName("BangDiem.BangDiemDAO").newInstance();
            ArrayList<BangDiem> listbd = bangDiemDAO.findByIDSinhVien(masv);
            for (BangDiem bd : listbd) {
                dtmMark.addRow(toOjectBd(bd));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Object[] toOjectBd(BangDiem bd) {
        Object[] objects = {bd.getMasv(), bd.getMamh(), bd.getLanthi(), bd.getHeso(), bd.getDiem(), bd.isTrangthai()};
        return objects;
    }
    private void jbtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSearchActionPerformed
        timkiem();
    }//GEN-LAST:event_jbtSearchActionPerformed

    private void jtfmalopKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmalopKeyReleased
        jPanel8.setVisible(false);
        jPanel5.setVisible(false);
        timkiem();
    }//GEN-LAST:event_jtfmalopKeyReleased

    private void jtfmalopKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmalopKeyPressed
        jPanel8.setVisible(false);
        jPanel5.setVisible(false);
        timkiem();
    }//GEN-LAST:event_jtfmalopKeyPressed

    private void jtfmasvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmasvKeyPressed
        timKiemDiem();
    }//GEN-LAST:event_jtfmasvKeyPressed

    private void jtfmasvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmasvKeyReleased
        timKiemDiem();
    }//GEN-LAST:event_jtfmasvKeyReleased

    private void jtfmasvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmasvKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfmasvKeyTyped

    private void jbtnsearchmasvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnsearchmasvActionPerformed
        timKiemDiem();
    }//GEN-LAST:event_jbtnsearchmasvActionPerformed

    private void jtbbangdiemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbbangdiemMouseReleased
        loadDataUpComponentBD();
    }//GEN-LAST:event_jtbbangdiemMouseReleased

    private void jtbbangdiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbbangdiemKeyReleased
        loadDataUpComponentBD();
    }//GEN-LAST:event_jtbbangdiemKeyReleased

    private void jtfmalopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfmalopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfmalopActionPerformed

    private void jtfmasvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfmasvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfmasvActionPerformed

    private void jtfMaSV2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMaSV2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMaSV2ActionPerformed

    private void jbtUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdate1ActionPerformed
        String masv = jtfMaSV2.getText();
        String tensv = jtfHoTen2.getText();
        String hedt = jtfHeDaoTao2.getText();
        String diachi = jtfDiaChi2.getText();
        String sdt = jtfDienThoai2.getText();
        String ngaysinh = jtfngaysinh2.getText();
        // String ngaysinh = jdate.getDateFormatString();
        // String strPattern = "[^a-z ]";
        boolean gioitinh = jrbsex2.isSelected();

        String malop = allClass.get(jcblop2.getSelectedIndex()).getMalop();

        Check c = new Check();
        if (!checkinfo()) {
            return;
        }

        Date d = null;
        if (ngaysinh == null || ngaysinh.equals("") || !ngaysinh.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Lỗi ngày sinh", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfngaysinh2.setText("");
            jtfngaysinh2.requestFocus();
            return;
        } else {
            try {
                d = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
            } catch (ParseException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }

        SinhVien sinhVien = new SinhVien(masv, tensv, malop, diachi, hedt, d, gioitinh, sdt);
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn thay đổi thông tin về sinh viên này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            SinhVien updateByID = new SinhVienDAO().updateByID(sinhVien);

            if (updateByID != null) {
                showAllSV();
            }
        }
    }//GEN-LAST:event_jbtUpdate1ActionPerformed

    private void jtbTTSVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbTTSVKeyReleased
        loadDataDownCoponnent();
    }//GEN-LAST:event_jtbTTSVKeyReleased

    private void jtfmalopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmalopKeyTyped
        jPanel8.setVisible(false);
        jPanel5.setVisible(false);
        timkiem();
    }//GEN-LAST:event_jtfmalopKeyTyped

    private void jbtDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDelete1ActionPerformed
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            try {

                String masv = jtfMaSV2.getText();
                new SinhVienDAO().deleteIDSinhVien(masv);
                while (dtm.getRowCount() > 0) {
                    dtm.removeRow(0);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Sinh viên này có điểm, hãy xóa điểm của sinh viên này trước", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Sinh viên này có điểm, hãy xóa điểm của sinh viên này trước", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
//            while (dtm.getRowCount() > 0) {
//                dtm.removeRow(0);
//
//            }
            jPanel8.setVisible(false);
            jPanel5.setVisible(false);

        }
    }//GEN-LAST:event_jbtDelete1ActionPerformed

    private void jcbMaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMaLopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbMaLopActionPerformed

    private void jbtUpdateBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdateBDActionPerformed
        if (!checkinfoBD()) {
            return;
        }
        String diem = jtfDiem.getText();
        int lanthi = jcbLanthi.getSelectedIndex();
        int heso = jcbHeSo.getSelectedIndex();
        boolean trangthai = jrbTrangthai.isSelected();
        String masv = listsv.get(jcbMasv.getSelectedIndex()).getMasv();
        String mamh = listmh.get(jcbMaMH.getSelectedIndex()).getMamh();

        float diemsv;
        diemsv = Float.parseFloat(diem);
        if (diemsv > 10 || diemsv < 0) {
            JOptionPane.showMessageDialog(this, "Điểm phải nhập là số từ 0 - 9. Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jtfDiem.requestFocus();
            return;
        }

        if (lanthi == 0) {
            JOptionPane.showMessageDialog(this, "Lần Thi phải lớn hơn 0. Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (heso == 0) {
            JOptionPane.showMessageDialog(this, "Hệ số phải lớn hơn 0. Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        BangDiem bd = new BangDiem(masv, mamh, lanthi, heso, diemsv, trangthai);
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn sửa điểm sinh viên này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            BangDiem updateID = new BangDiemDAO().upDate(bd);
            if (updateID != null) {
                showAllBD();
            }

            jcbMasv.setEnabled(false);
            jcbMaMH.setEnabled(false);
            jcbLanthi.setEnabled(false);
            jcbMaLop.setEnabled(false);

    }//GEN-LAST:event_jbtUpdateBDActionPerformed
    }
    private void jbtDeleteBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteBDActionPerformed
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {

            try {
                String masv = listsv.get(jcbMasv.getSelectedIndex()).getMasv();
                String mamh = listmh.get(jcbMaMH.getSelectedIndex()).getMamh();
                int lanthi = jcbLanthi.getSelectedIndex();
                new BangDiemDAO().delBangDiem(masv, mamh, lanthi);
                while (dtmMark.getRowCount() > 0) {
                    dtmMark.removeRow(0);

                }

            } catch (SQLException ex) {
                Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
            }

            //  resetForm();
            //loadDataBD();            
    }//GEN-LAST:event_jbtDeleteBDActionPerformed
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtDelete1;
    private javax.swing.JButton jbtDeleteBD;
    private javax.swing.JButton jbtSearch;
    private javax.swing.JButton jbtUpdate1;
    private javax.swing.JButton jbtUpdateBD;
    private javax.swing.JButton jbtnsearchmasv;
    private javax.swing.JComboBox jcbHeSo;
    private javax.swing.JComboBox jcbLanthi;
    private javax.swing.JComboBox jcbMaLop;
    private javax.swing.JComboBox jcbMaMH;
    private javax.swing.JComboBox jcbMasv;
    private javax.swing.JComboBox jcblop2;
    private javax.swing.JRadioButton jrbTrangthai;
    private javax.swing.JRadioButton jrbsex2;
    private javax.swing.JTable jtbTTSV;
    private javax.swing.JTable jtbbangdiem;
    private javax.swing.JTextField jtfDiaChi2;
    private javax.swing.JTextField jtfDiem;
    private javax.swing.JTextField jtfDienThoai2;
    private javax.swing.JTextField jtfHeDaoTao2;
    private javax.swing.JTextField jtfHoTen2;
    private javax.swing.JTextField jtfMaSV2;
    private javax.swing.JTextField jtfmalop;
    private javax.swing.JTextField jtfmasv;
    private javax.swing.JTextField jtfngaysinh2;
    // End of variables declaration//GEN-END:variables

    private void loadDataDownCoponnent() {
        jtfMaSV2.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 0).toString());
        jtfHoTen2.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 1).toString());
        jcblop2.setSelectedItem(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 2).toString());
        jtfHeDaoTao2.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 3).toString());
        jtfngaysinh2.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 4).toString());
        // jdate.setDateFormatString(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 4).toString());
        jtfDiaChi2.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 5).toString());
        jtfDienThoai2.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 7).toString());
        String sex = jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 6).toString();
        if (sex.equals("Nam")) {
            jrbsex2.setSelected(true);
        } else {
            jrbsex2.setSelected(false);
        }
//        
        jtfMaSV2.setEnabled(false);
    }

    private boolean checkinfo() {
        Check c = new Check();
        if (!c.checkID(jtfMaSV2.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập mã sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfMaSV2.setText("");
            jtfMaSV2.requestFocus();
            return false;
        } else if (!c.checkSpace(jtfHoTen2.getText()) || !c.check(jtfHoTen2.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập tên sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfHoTen2.setText("");
            jtfHoTen2.requestFocus();
            return false;

        } else if (!c.checkSpace(jtfHeDaoTao2.getText()) || !c.check(jtfHeDaoTao2.getText())) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại nhập hệ đào tạo", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfHeDaoTao2.setText("");
            jtfHeDaoTao2.requestFocus();
            return false;
        } else if (!c.checkSpace(jtfDiaChi2.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập địa chỉ sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfDiaChi2.setText("");
            jtfDiaChi2.requestFocus();
            return false;

        } else if (!c.checkSpace(jtfDienThoai2.getText()) || !c.checkPhone(jtfDienThoai2.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập phone sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfDienThoai2.setText("");
            jtfDienThoai2.requestFocus();
            return false;
        }
        return true;
    }

    private void showAllSV() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);

        }
        String masv = jtfMaSV2.getText();
        ArrayList<SinhVien> svs = new SinhVienDAO().getAllByIDSV(masv);
        for (SinhVien sv : svs) {
            Vector vector = new Vector();
            vector.add(sv.getMasv());
            vector.add(sv.getTensv());
            vector.add(sv.getMalop());
            vector.add(sv.getHedaotao());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            vector.add(dateFormat.format(sv.getNgaysinh()));
            vector.add(sv.getDiachi());
            if (sv.isGioitinh() == true) {
                vector.add("Nam");
            } else {
                vector.add("Nữ");
            }
            vector.add(sv.getSodt());
            dtm.addRow(vector);

        }

    }

    private void loadDataUpComponentBD() {
        jPanel7.setVisible(true);
        jPanel6.setVisible(true);
        jcbMaLop.enable(false);
        jcbMasv.enable(false);
        jcbMaMH.enable(false);
        jcbLanthi.enable(false);

        jcbMasv.setSelectedItem(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 0).toString());
        jcbMaMH.setSelectedItem(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 1).toString());
        jcbLanthi.setSelectedItem(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 2).toString());
        jcbHeSo.setSelectedItem(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 3).toString());
        jtfDiem.setText(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 4).toString());
        String trangthai = jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 5).toString();
        if (trangthai.equals("true")) {
            jrbTrangthai.setSelected(true);
        } else {
            jrbTrangthai.setSelected(false);

        }
    }

    private boolean checkinfoBD() {
        Check c = new Check();
        if (!c.checkSpace(jtfDiem.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập điểm sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfDiem.setText("");
            jtfDiem.requestFocus();
            return false;
        }
        return true;
    }

    private void showAllBD() {
        while (dtmMark.getRowCount() > 0) {
            dtmMark.removeRow(0);
        }
        ArrayList<BangDiem> bangDiems = new BangDiemDAO().getAll();
        for (BangDiem bd : bangDiems) {
            Vector v = new Vector();
            v.add(bd.getMasv());
            v.add(bd.getMamh());
            v.add(bd.getLanthi());
            v.add(bd.getHeso());
            v.add(bd.getDiem());
            if (bd.isTrangthai() == true) {
                v.add("true");
            } else {
                v.add("false");

            }
            dtmMark.addRow(v);
        }
    }
}
