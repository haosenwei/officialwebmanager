package com.official.web.origin.entity.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class MysqlFieldType {
	static Map<String, DataTypeJavaSql> map = new HashMap<String, DataTypeJavaSql>();

	static {
		map.put("1", new DataTypeJavaSql("bit","boolean","BOOLEAN","1"));
		map.put("2", new DataTypeJavaSql("boolean","boolean","BOOLEAN","1"));

		map.put("3", new DataTypeJavaSql("tinyint","byte","BYTE","4"));
		map.put("4", new DataTypeJavaSql("smallint","short","SMALLINT","6"));
		map.put("5", new DataTypeJavaSql("mediumint","short", "mediumint","9" ));
		map.put("6", new DataTypeJavaSql("integer","int","INTEGER","11"));
		map.put("7", new DataTypeJavaSql("bigint","Long","BIGINT","20"));
		map.put("8", new DataTypeJavaSql("float","double","FLOAT"));
		map.put("9", new DataTypeJavaSql("double","double","DOUBLE"));
		map.put("10", new DataTypeJavaSql("decimal","java.math.bigdecimal","DECIMAL","10,0"));

		map.put("11", new DataTypeJavaSql("date","Date","DATE"));
		map.put("12", new DataTypeJavaSql("time","Date","TIME"));
		map.put("13", new DataTypeJavaSql("datetime","Date","TIMESTAMP"));
		map.put("14", new DataTypeJavaSql("timestamp","Date","TIMESTAMP"));

		map.put("15", new DataTypeJavaSql("char","String","CHAR","1"));
		map.put("16", new DataTypeJavaSql("varchar","String","varchar","100"));
		map.put("17", new DataTypeJavaSql("tinyblob","byte[]","TINYBLOB"));
		map.put("18", new DataTypeJavaSql("tinytext","String","TINYTEXT"));
		map.put("19", new DataTypeJavaSql("blob","byte[]","BLOB"));
		map.put("20", new DataTypeJavaSql("text","String","TEXT"));
		map.put("21", new DataTypeJavaSql("mediumblob","byte[]","MEDIUMBLOB"));
		map.put("22", new DataTypeJavaSql("mediumtext","String","MEDIUMTEXT"));
		map.put("23", new DataTypeJavaSql("longblob","byte[]","LONGBLOB"));
		map.put("24", new DataTypeJavaSql("longtext","String","LONGTEXT"));
		
		map.put("25", new DataTypeJavaSql("int","int","INTEGER","11"));
		List<DataTypeJavaSql> list = new ArrayList<DataTypeJavaSql>();
		for (String key: map.keySet()) {
			DataTypeJavaSql dataTypeJavaSql = map.get(key);
			list.add(dataTypeJavaSql);
		}
		for (DataTypeJavaSql dataTypeJavaSql : list) {
			map.put(dataTypeJavaSql.getSqlDataType(), dataTypeJavaSql);
		}
	}

	public static DataTypeJavaSql get(String key) {
		return map.get(key);
	}

	public static String getDateTypeId(String dataType) {
		if (StringUtils.isBlank(dataType)) {
			return null;
		}

		for (String key : map.keySet()) {
			DataTypeJavaSql val = map.get(key);
			String dataTypeDb = val.getSqlDataType();
			if (dataTypeDb.equals(dataType)) {
				return key;
			}
		}
		return null;
	}

	/*
	 * java.lang.Boolean, boolean 数据库兼容的 BOOLEAN ByteTypeHandler java.lang.Byte,
	 * byte 数据库兼容的 NUMERIC 或 BYTE ShortTypeHandler java.lang.Short, short 数据库兼容的
	 * NUMERIC 或 SHORT INTEGER IntegerTypeHandler java.lang.Integer, int 数据库兼容的
	 * NUMERIC 或 INTEGER LongTypeHandler java.lang.Long, long 数据库兼容的 NUMERIC 或
	 * LONG INTEGER FloatTypeHandler java.lang.Float, float 数据库兼容的 NUMERIC 或
	 * FLOAT DoubleTypeHandler java.lang.Double, double 数据库兼容的 NUMERIC 或 DOUBLE
	 * BigDecimalTypeHandler java.math.BigDecimal 数据库兼容的 NUMERIC 或 DECIMAL
	 * StringTypeHandler java.lang.String CHAR, VARCHAR ClobTypeHandler
	 * java.lang.String CLOB, LONGVARCHAR NStringTypeHandler java.lang.String
	 * NVARCHAR, NCHAR NClobTypeHandler java.lang.String NCLOB BlobTypeHandler
	 * byte[] BLOB, LONGVARBINARY DateTypeHandler java.util.Date TIMESTAMP
	 * DateOnlyTypeHandler java.util.Date DATE TimeOnlyTypeHandler
	 * java.util.Date TIME SqlTimestampTypeHandler java.sql.Timestamp TIMESTAMP
	 * SqlDateTypeHandler java.sql.Date DATE SqlTimeTypeHandler java.sql.Time
	 * TIME EnumTypeHandler Enumeration Type VARCHAR-任何兼容的字符串类型，存储枚举的名称（而不是索引）
	 * EnumOrdinalTypeHandler Enumeration Type 任何兼容的 NUMERIC 或 DOUBLE
	 * 类型，存储枚举的索引（而不是名称）。 InstantTypeHandler java.time.Instant TIMESTAMP
	 * LocalDateTimeTypeHandler java.time.LocalDateTime TIMESTAMP
	 * LocalDateTypeHandler java.time.LocalDate DATE LocalTimeTypeHandler
	 * java.time.LocalTime TIME OffsetDateTimeTypeHandler
	 * java.time.OffsetDateTime TIMESTAMP OffsetTimeTypeHandler
	 * java.time.OffsetTime TIME ZonedDateTimeTypeHandler
	 * java.time.ZonedDateTime TIMESTAMP YearTypeHandler java.time.Year INTEGER
	 * MonthTypeHandler java.time.Month INTEGER YearMonthTypeHandler
	 * java.time.YearMonth VARCHAR or LONGVARCHAR JapaneseDateTypeHandler
	 * java.time.chrono.JapaneseDate DATE
	 */
}