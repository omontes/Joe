SELECT C.`TotalContadoReportado`,C.`TotalTarjetaReportado`,C.`ReporteFinal`,C.`HoraCierre`,C.`Gastos`
FROM cierredecaja AS C
WHERE C.idCierreDeCaja=?;
