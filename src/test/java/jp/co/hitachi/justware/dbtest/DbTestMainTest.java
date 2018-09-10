/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.hitachi.justware.dbtest;


import java.io.File;
import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 康太
 */
public class DbTestMainTest {
    
    /** DBUnitのテスター **/
    private static IDatabaseTester databaseTester;
    
    @Before
    public void setUp() throws Exception {
        databaseTester = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/postgres", "postgres","gef4nxs9");
        
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File("./data/Before.xml"));
        databaseTester.setDataSet(dataSet);
        
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.onSetup();
    }
    
    @After
    public void tearDown() throws Exception {
        databaseTester.setTearDownOperation(DatabaseOperation.NONE);
        databaseTester.onTearDown();
    }
    
    @Test
    public void test(){
        DbTestMain.main(null);
        
        try {
            IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("./data/After.xml"));
            ITable expectedTable = expectedDataSet.getTable("emp5");

            IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
            ITable actualTable = databaseDataSet.getTable("emp5");

            // 時間に対するAssertionはほぼ確実に失敗するので検証対象から除外する
            ITable filteredExpectedTable = DefaultColumnFilter.excludedColumnsTable(
                    expectedTable, new String[]{"hiredate"});
            ITable filteredActualTable;
            filteredActualTable = DefaultColumnFilter.excludedColumnsTable(
                    actualTable, new String[]{"hiredate"});

            // ---------------------------------------------------------------
            // 更新結果の検証はJUnitではなくDBUnitのAssertionを使用する
            // ---------------------------------------------------------------
            Assertion.assertEquals(filteredExpectedTable, filteredActualTable);
        } catch (Exception e) {
            fail("予期しないエラーでテストが失敗しました。");
        }

    }
       
}
