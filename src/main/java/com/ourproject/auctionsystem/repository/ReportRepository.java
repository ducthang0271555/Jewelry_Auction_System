package com.ourproject.auctionsystem.Repo;
import java.util.List;

public interface ReportRepository {
    void createReport(Report report);
    void updateReport(Report report);
    void deleteReport(int reportId);
    Report getReportById(int reportId);
    List<Report> getAllReports();
}
