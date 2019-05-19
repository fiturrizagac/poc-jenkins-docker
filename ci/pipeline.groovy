println "Hello World!"
println "Hello World 222222!"


def command = "echo ${env}"
def proc = command.execute()
proc.waitFor()              

println "Process exit code: ${proc.exitValue()}"
println "Std Err: ${proc.err.text}"
println "Std Out: ${proc.in.text}" 