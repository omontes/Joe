UPDATE cierredecaja AS C
SET C.`HoraCierre`=?,C.`TotalVendido`=?,C.`Observaciones`=?,C.`ReporteFinal`=?,C.`TotalContado`=?,C.`TotalTarjeta`=?,C.`TotalContadoReportado`=?,C.`TotalTarjetaReportado`=?
WHERE C.`idCierreDeCaja`=?;