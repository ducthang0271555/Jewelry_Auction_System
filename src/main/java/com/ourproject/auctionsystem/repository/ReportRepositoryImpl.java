package com.ourproject.auctionsystem.Repo;

import java.util.ArrayList;
import java.util.List;

public class ReportRepositoryImpl implements ReportRepository {
    private List<Report> reports = new ArrayList<>();

    @Override
    public void createReport(Report report) {
        reports.add(report);
    }

    @Override
    public void updateReport(Report report) {
        int index = reports.indexOf(getReportById(report.getReportId()));
        if (index >= 0) {
            reports.set(index, report);
        }
    }

    @Override
    public void deleteReport(int reportId) {
        Report report = getReportById(reportId);
        if (report != null) {
            reports.remove(report);
        }
    }

    @Override
    public Report getReportById(int reportId) {
        return reports.stream()
                .filter(report -> report.getReportId() == reportId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Report> getAllReports() {
        return new ArrayList<>(reports);
    }
}
