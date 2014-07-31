package name.yamamoto.satoshi.java8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;


public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// オブジェクトの生成
		LocalDateTime timePoint = LocalDateTime.now();	// 現在の日付と時刻
		LocalDate.of(2012, Month.DECEMBER, 12);	// 値から作成
		LocalDate.ofEpochDay(150);	// 1970年の中頃
		LocalTime.of(17, 18);	// 今日の帰宅時に利用した電車
		LocalTime.parse("10:15:30");	// 文字列から作成
		
		// 値の取得は標準的なgetterを使う
		LocalDate theDate = timePoint.toLocalDate();
		Month month = timePoint.getMonth();
		int day = timePoint.getDayOfMonth();
		timePoint.getSecond();
		
		// 値を変更するメソッドは withと呼ばれ、新しいオブジェクトを返す
		LocalDateTime thePast = timePoint
				.withDayOfMonth(10)
				.withYear(2010);
		// 値とフィールドのペア
		LocalDateTime yetAnother = thePast
				.plusWeeks(3)
				.plus(3, ChronoUnit.WEEKS);
		
		// Adjusterは、日付を操作するコードブロック
		// * withAdjuster: ひとつ以上のフィールドを設定するためのクラス
		// * plusAdjuster: フィールド同士の加算や減算に使用するためのクラス
		LocalDateTime foo = timePoint.with(
				TemporalAdjusters.lastDayOfMonth());
		LocalDateTime bar = timePoint.with(
				TemporalAdjusters.previousOrSame(DayOfWeek.WEDNESDAY));
		
	}

}
