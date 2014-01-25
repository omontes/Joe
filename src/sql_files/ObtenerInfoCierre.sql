SELECT C.`TotalContadoReportado`,C.`TotalTarjetaReportado`,C.`ReporteFinal`,C.`HoraCierre`
FROM cierredecaja AS C
WHERE C.idCierreDeCaja=?;
