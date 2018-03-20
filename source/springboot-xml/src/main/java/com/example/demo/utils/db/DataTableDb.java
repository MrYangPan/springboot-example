package com.example.demo.utils.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataTableDb extends ArrayList<RowDb> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3057968190529400383L;

	public static DataTableDb execute(Connection connection, String query)
			throws SQLException {
		return parse(connection.prepareStatement(query).executeQuery());
	}

	public static DataTableDb parse(ResultSet resultSet) throws SQLException {
		ResultSetMetaData metaData = resultSet.getMetaData();
		DataTableDb dataTable = new DataTableDb();
		dataTable.columns = new ColumnCollectionDb();

		int colCount = metaData.getColumnCount();
		for (int i = 1; i <= colCount; i++) {
			ColumnDb column = new ColumnDb();
			column.setCatalogName(metaData.getCatalogName(i));
			column.setColumnClassName(metaData.getColumnClassName(i));
			column.setDisplaySize(metaData.getColumnDisplaySize(i));
			column.setLabel(metaData.getColumnLabel(i));
			column.setName(metaData.getColumnName(i));
			column.setPrecision(metaData.getPrecision(i));
			column.setScale(metaData.getScale(i));
			column.setSchemaName(metaData.getSchemaName(i));
			column.setTableName(metaData.getTableName(i));
			column.setType(metaData.getColumnType(i));
			column.setTypeName(metaData.getColumnTypeName(i));
			dataTable.columns.add(column);
		}

		while (resultSet.next()) {
			Object[] data = new Object[colCount];
			for (int i = 1; i <= data.length; i++) {
				data[i - 1] = resultSet.getObject(i);
			}
			dataTable.add(new RowDb(dataTable, data));
		}
		resultSet.close();
		return dataTable;
	}

	private ColumnCollectionDb columns;

	public ColumnCollectionDb getColumns() {
		return columns;
	}

	@Override
	public String toString() {
		String s = columns.toString() + "\n";
		if (size() == 0) {
			s += "Rows is empty\n";
		} else {
			s += "Rows : {" + String.valueOf(get(0));
			for (int i = 1; i < size(); i++) {
				s += "\n" + String.valueOf(get(i));
			}
			s += "}\n";
		}
		return s;
	}
}
