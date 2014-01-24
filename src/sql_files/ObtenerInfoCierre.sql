SELECT C.`TotalContadoReportado`,C.`TotalTarjetaReportado`,C.`ReporteFinal`
FROM cierredecaja AS C
WHERE C.idCierreDeCaja=?;
