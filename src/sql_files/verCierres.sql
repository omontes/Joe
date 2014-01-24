SELECT C.`idCierreDeCaja` AS NumCierre, C.`HoraInicio` AS FechaInicio, C.`HoraCierre` AS FechaFinal
FROM cierredecaja AS C
WHERE C.`ReporteFinal` IS NOT NULL
ORDER BY C.`idCierreDeCaja`;

