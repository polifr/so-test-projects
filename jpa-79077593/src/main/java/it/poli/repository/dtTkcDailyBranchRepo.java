package it.poli.repository;

import it.poli.entity.dtTkcDailyByBranch;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// see https://thorben-janssen.com/spring-data-jpa-dto-native-queries

@Repository
public interface dtTkcDailyBranchRepo extends JpaRepository<dtTkcDailyByBranch, Long> {
  // enter date
  // receive dt_tkc của branch
  @Query(
      value =
          """
            SELECT
                ROW_NUMBER() OVER (ORDER BY a.sum_date DESC,a2. branch_name ASC, SUM(a.total_credit) / 1000000 DESC) AS id,
                SUM(a.total_credit) / 1000000 AS dtTkc,
                a2. branch_name AS tenChiNhanh,
                a.sum_date AS ngayThang
            FROM
                DTTKC_DAILY a,
                dm_tree_list b,
                dm_area a1,
                area_list a2
            WHERE
                TRUNC(a.sum_date) = :sumDate
                AND a.tree_id = b.tree_id
                AND TRUNC(a.sum_date) = TRUNC(b.sum_date)
                AND b.linh_vuc = 'S'
                AND a.active_year = 'N'
                AND a.is_corporate = '1'
                AND b.cap2_sum IN ('D', 'G', 'K', 'R', 'T')
                AND a.network_id = '1'
                AND a.district_number = a1.district_number
                AND a1.center = '1'
                AND a1.province_code || a1.district_code = a2.district_code
            GROUP BY
                a2. branch_name, a.sum_date
            ORDER BY
                a.sum_date DESC, id DESC
            """,
      nativeQuery = true)
  List<dtTkcDailyByBranch> findBranchSumDate(@Param("sumDate") LocalDate sumDate);
}
