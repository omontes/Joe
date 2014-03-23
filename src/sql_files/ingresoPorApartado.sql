SELECT SUM(PFP.`PagoTarjeta`+PFP.`PagoContado`)
FROM factura AS F,facturaspendientes AS FP, pagosfactpendientes AS PFP
WHERE F.Estado ='A' AND F.idFactura=FP.idFactura AND F.Concepto='Apartado'
AND PFP.idFacturaVersionPagosPend=FP.idVersionFactPendientes 
AND F.idVersionFactura=FP.idVersionFactPendientes AND PFP.idFacturaPendiente=FP.idFactura 
AND SUBSTRING(PFP.Fecha,1,10)  BETWEEN ? AND ?;